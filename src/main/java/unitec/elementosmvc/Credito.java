/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

/**
 *
 * @author T-107
 */
public class Credito implements Tarjeta
{
    @Override
    public void obtenerSaldo() 
    {
        System.out.println("Saldo: 20,000");
    }
}
