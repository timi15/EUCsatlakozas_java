import java.time.LocalDate;

class Csatlakozas {

    public final String orszag;
    public  LocalDate csatlakozas;

    public Csatlakozas(String row) {  //CONSTRUCTOR

        String [] slices = row.split(";");
        this.orszag=slices[0];

        try {

            this.csatlakozas= LocalDate.parse(slices[1].replace(".","-"));

        } catch (Exception ex){

            System.out.println("Error "+ ex.getMessage());

        }

    }

    public String getOrszag() {
        return orszag;
    }

    public LocalDate getCsatlakozas() {
        return csatlakozas;
    }

    @Override
    public String toString() {
        return "Csatlakozas{" +
                "orszag='" + orszag + '\'' +
                ", csatlakozas=" + csatlakozas +
                '}';
    }
}
