package ba.unsa.etf.rpr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Messenger {
    private ArrayList<Poruka> poruke = new ArrayList<>();

    public Messenger() {
        poruke = new ArrayList<>();
    }
//PROVEJRI NEGRAAAAAAAAAAAAAAAAAAAAAA
    public ArrayList<Poruka> dajSvePoruke() {
        return poruke;
    }

    public void posaljiPoruku(Korisnik posiljalac, Korisnik primalac, String tekstPoruke) throws NeispravanFormatPoruke {
        Poruka poruka = new Poruka(posiljalac,primalac, LocalDateTime.now(),tekstPoruke);
        poruke.add(poruka);
    }

    public void posaljiPoruku(Poruka poruka) {
        poruke.add(poruka);
    }

    public void posaljiPoruke(List<Poruka> listaPoruka) {
        for (Poruka por1 : listaPoruka) {
            poruke.add(por1);
        }

    }

    public void ponistiSlanje(Poruka poruka) throws NeispravnaAkcija {
        boolean imaPoruke = false;

        for (Poruka por1 : poruke) {
            if(por1.equals(poruka)){
                imaPoruke = true;
                break;
            }
        }
        if(!imaPoruke){
           throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja nije nikada poslana!");
        }
        if(poruka.getStatusPoruke().equals(StatusPoruke.PROCITANA)){
            throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja je već pročitana!");
        }

        if(poruka.getStatusPoruke().equals(StatusPoruke.NEPROCITANA)){
            poruke.remove(poruka);
        }

    }

    public void procitajPoruku(Poruka poruka) {

    }
}
