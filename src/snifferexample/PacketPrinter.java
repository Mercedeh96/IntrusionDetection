/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snifferexample;

import jpcap.PacketReceiver;
import jpcap.packet.Packet;

public class PacketPrinter implements PacketReceiver{

@Override
public void receivePacket(Packet packet) {
 

System.out.println("Packet :"+ packet.toString());
} 
}
