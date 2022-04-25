import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Orszag {
    public static void main(String[] args) {

        ArrayList<Csatlakozas> eu= new ArrayList<>();
        String uri = "eucsatlakozas (1).txt";
        List<String> rows = readIn(uri);
        eu =load(rows);

        feladat3(eu);

        System.out.println();

        int orsz2007 =feladat4(eu);
        System.out.println("2007-ben "+orsz2007+" ország csatlakozott.");

        System.out.println();

        feladat5(eu);

        System.out.println();

        feladat6(eu);


    } //main vége

    private static void feladat6(ArrayList<Csatlakozas> eu) {

        System.out.println("6. feladat");

        System.out.println("Határozza meg, hogy májusban történt- e csatlakozás az EU-hoz");

        boolean van = false;

        for (Csatlakozas sor: eu) {

            if (sor.csatlakozas.getMonth() == Month.MAY) {
                van = true;
                break;
            }
        }

            if(van){

                System.out.println("Volt májusban csatlakozás");

            }

            else{

                System.out.println("Nem volt májusban csatlakozás");

            }

        }



    private static void feladat5(ArrayList<Csatlakozas> eu) {

        System.out.println("5. feladat");

        System.out.println("Határozza meg és írja ki a képernyőre a minta szerint Magyarország csatlakozásának dátumát!");

        for (Csatlakozas sor:eu ) {

            if(sor.orszag.equals("Magyarország")){

                System.out.println("Magyarország csatlakozásának dátuma: "+sor.csatlakozas);

            }

        }

    }

    private static int feladat4 (ArrayList<Csatlakozas> eu) {

        System.out.println("4. feladat");

        System.out.println("Határozza meg és írja ki a képernyőre a minta szerint a 2007-ben csatlakozott országok számát!");

        int db = 0;

        for  ( Csatlakozas sor: eu) {

            if( sor.csatlakozas.getYear()==2007){

                db++;

            }

        }

        return db;

    }

    private static void feladat3(ArrayList<Csatlakozas> eu) {

        System.out.println("3. feladat");

        System.out.println("Határozza meg és írja ki a képernyőre a minta szerint, hogy hány tagállama volt 2018-ban az Európai Uniónak!");

        System.out.println("EU tagállamainak száma: "+eu.size()+" db");

    }

    private static ArrayList<Csatlakozas> load(List<String> rows) {

        ArrayList <Csatlakozas> orszagok= new ArrayList<>();

        for (String row: rows ) {

            orszagok.add(new Csatlakozas(row));

        }

        return orszagok;

    }

    private static List<String> readIn(String uri) {

        List<String> rows = new ArrayList<>();

        try {

            rows = Files.readAllLines(Paths.get(uri), Charset.forName("UTF-8"));

        } catch (IOException ex) {

            System.out.println("Error:  " + ex.getMessage());

        }

        rows.remove(0);

        return rows;

    }

}
