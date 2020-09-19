package ba.unsa.etf.rpr;

public class Korisnik {
    private String ime;
    private String prezime;
    private String nadimak;

    public Korisnik(String ime, String prezime, String nadimak) {
        if(ime==null || prezime==null || nadimak==null){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        }
        if(ime=="" || prezime=="" || nadimak==""){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");
        }
        if(nadimak.length()<5){
            throw new IllegalArgumentException("Nadimak mora imati 5 ili više karaktera!");
        }
        this.ime = ime;
        this.prezime = prezime;
        this.nadimak = nadimak;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if(ime==null){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        }
        if(ime==""){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");
        }
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        if(prezime==null){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        }
        if(prezime==""){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");
        }
        this.prezime = prezime;
    }

    public String getNadimak() {
        return nadimak;
    }

    public void setNadimak(String nadimak) {
        if(nadimak==null){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        }
        if(nadimak==""){
            throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");
        }
        if(nadimak.length()<5){
            throw new IllegalArgumentException("Nadimak mora imati 5 ili više karaktera!");
        }
        this.nadimak = nadimak;
    }

    @Override
    public String toString() {
        return ime +" "+ prezime +" "+  "(" + nadimak + ")";
    }
}
