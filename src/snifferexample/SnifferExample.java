/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snifferexample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.NetworkInterface;
import jpcap.packet.Packet;

/**
*
* @author Ruchira
*/
public class SnifferExample {

JpcapCaptor captor;
NetworkInterface[] interfaceList;

//Change this number according to the Network Interface which you wish to Sniff
private static final int interfaceNumber=1;

public static void main(String[] str) {
SnifferExample sniff=new SnifferExample();
sniff.printNetworkInterfaceList();
try {
sniff.capture();
} catch (IOException ex) {
Logger.getLogger(SnifferExample.class.getName()).log(Level.SEVERE, null, ex);
}
}


/**
* Run this method first and it will list out the available network interfaces in your computer
* All of the interfaces will be put into an array (interfaceList)
*/
public void printNetworkInterfaceList() {

interfaceList = JpcapCaptor.getDeviceList();

System.out.println("Number of Network Interfaces Found :"+interfaceList.length);

for (int i = 0; i < interfaceList.length; i++) {
System.out.println("Index :" + i + ", Network Device Name :" + interfaceList[i].name + ", Description :" +
" " + interfaceList[i].description);
}
}




public void capture() throws IOException { 


//for (int i = 0; i < interfaceList.length; i++) {
captor=JpcapCaptor.openDevice(interfaceList[3], 65535, true, 20000);
//open a file to save captured packets
JpcapWriter writer=JpcapWriter.openDumpFile(captor,"PacketInformation.txt");

for(int i=0;i<10;i++){
  //capture a single packet
  Packet packet=captor.getPacket();
    System.out.println("packet" + packet.toString());
  //save it into the opened file
  writer.writePacket(packet);
}
writer.close();

//captor.loopPacket(-1, new PacketPrinter());
//captor.close();
//}

//for(int i=0;i<10;i++){
  //capture a single packet
  //Packet packet=captor.getPacket();
  //save it into the opened file
 // writer.writePacket(packet);
//}
//writer.close();

}


}

