
import core.DatabaseManager;
import model.Anggota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Donny Kusuma
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatabaseManager.getDBConnection();
        Anggota a[] = Anggota.showAnggota();
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].getUsername());
        }
        
    }
    
}
