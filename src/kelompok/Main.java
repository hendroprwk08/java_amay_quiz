package kelompok;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Member> members = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
    
        do{
            System.out.println("=========================================");
            System.out.println("           Mnj Member");
            System.out.println("=========================================");
            System.out.println("  1. Tampilkan Member ");
            System.out.println("  2. Isi data");
            System.out.println("  3. Hapus data");
            System.out.println("  4. keluar");
            System.out.println("=========================================");
            System.out.print(" Type [ 1, 2, 3 or 4 ]: " );
            pilih = sc.nextInt();
        
            if ( pilih == 1 ){
                viewData( members );
            }else if ( pilih == 2 ){
                members = insertMember( members );
            }else if ( pilih == 3 ){
                removeData( members );
            }else{
                pilih = 4;
                System.out.print("[ Wrong number try again ]");
                sc.nextLine();
            }
        }while( pilih != 4 );
    }
    
    private static void viewData( ArrayList<Member> m ) {
        Scanner sc = new Scanner(System.in);
        
        if ( m.size() == 0){
            System.out.println("[ Data tak tersedia ] Tekan enter...");
            sc.nextLine();
        }else{
            int num = 1;
            for(int i = 0; i < m.size(); i++ ) {
                System.out.println("No. "+ num++ ); 
                System.out.println("Name. "+ m.get( i ).getNama()  ); 
                System.out.println("Tipe. "+ m.get( i ).getJenismember() ); 
                System.out.println("Akses. "+ m.get( i ).getAkses()); 
                System.out.println("Biaya. "+ m.get( i ).getBiaya() );
                System.out.println();
            }
            System.out.print("Tekan enter...");
            sc.nextLine();
        }
    }

    private static ArrayList<Member> insertMember(ArrayList<Member> m) {
        Scanner sc = new Scanner(System.in);
        
        String nama = null, tipe, akses = null;
        int biaya = 0;
        
        boolean ok = false;
        
        System.out.print("Nama: ");
        nama = sc.nextLine();
            
        //cek tipe pastikan ketikannya benar
        ok = false;
        do{ 
            System.out.print("Input tipe [ Star / Diamond / Gold ]: ");
            tipe = sc.nextLine();

            if ( tipe.equalsIgnoreCase("Star") || 
                    tipe.equalsIgnoreCase("Diamond") ||
                    tipe.equalsIgnoreCase("Gold") ) {
                ok = true;

            }else{
                System.out.println("[ Salah ketik tipe ]");
                ok = false;
            }
        } while ( ok == false );
        
        //cek akses pastikan ketikannya benar
        ok = false;
        do{ 
            System.out.print("Input akses [ Single / All ]: ");
            akses = sc.nextLine();

            if ( akses.equalsIgnoreCase("Single") || 
                    akses.equalsIgnoreCase("All") ) {
                ok = true;

            }else{
                System.out.println("[ Salah ketik hak akses ]");
                ok = false;
            }
        } while ( ok == false );
        
        if(ok == true){
            //cek biaya
            if(tipe.equalsIgnoreCase("Star"))
                biaya = 500000;
            else if(tipe.equalsIgnoreCase("Diamond"))
                biaya = 400000;
            else if(tipe.equalsIgnoreCase("Gold"))
                biaya = 300000;

            m.add(new Member( nama, tipe, akses, biaya ));

            System.out.println("[ "+ nama +" ditambahkan!  ] Tekan enter..." );
            sc.nextLine();
            
            return m; 
        }else{
            System.out.println("[ Gagal simpan data ] Tekan enter..." );
        }
        
        return null;
    }
    

    private static void removeData(ArrayList<Member> m) {
        Scanner sc = new Scanner(System.in);
        boolean correct;
        
        //view fruits
        System.out.println("[ Type "+ ( m.size() + 1 ) +" to exit ]" );
        System.out.print("=================================================");
        System.out.println();
        System.out.printf("| %-3s| %-6s| %-20s| %-10s|", 
                "No. ", 
                "Nama", 
                "Tipe", 
                "Biaya");
        System.out.println();
        System.out.print("=================================================");
        System.out.println();

        int num = 1;
        for(int i = 0; i < m.size(); i++ ) {
            System.out.printf("| %-3s| %-6s| %-20s| %-10s|", 
            num++ , 
            m.get(i).getNama(), 
            m.get(i).getJenismember(), 
            m.get(i).getBiaya());
            System.out.println();
        }

        System.out.print("=================================================");
        System.out.println();
        
        correct = true;
        do{ 
            System.out.print("Pilih nomer member yang akan dihapus [ 1 - "+ m.size() +" ]: " );
            idx = sc.nextInt();
            
            if ( idx > 0 && idx <= m.size() ){ 
                m.remove( idx - 1 );
                correct = true;
            }else{
                correct = false;
            }
        } while ( correct == false );
        
        System.out.println( "[ Member terhapus! ]. Tekan enter..." );
        sc.nextLine();
        sc.nextLine();    
    }
   
}
