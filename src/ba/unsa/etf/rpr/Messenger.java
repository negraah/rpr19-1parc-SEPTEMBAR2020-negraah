package ba.unsa.etf.rpr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Messenger {
    private ArrayList<Poruka> poruke;

    public Messenger() {
        this.poruke = new ArrayList<>();
    }

    public ArrayList<Poruka> dajSvePoruke() {
        return poruke;
    }

    public void posaljiPoruku(Poruka poruka) {
        poruke.add(poruka);
    }

    public void posaljiPoruku(Korisnik posiljalac, Korisnik primalac, String tekst) throws NeispravanFormatPoruke {
        Poruka poruka = new Poruka(posiljalac, primalac, LocalDateTime.now(), tekst);
        poruke.add(poruka);
    }


    public void posaljiPoruke(List<Poruka> poruke1) {
        for (Poruka por : poruke1) {
            poruke.add(por);
        }
    }

    public void ponistiSlanje(Poruka poruka) throws NeispravnaAkcija {
        boolean poslana = false;
        for (Poruka por : poruke) {
            if (poruka.equals(por)) {
                poslana = true;
                break;
            }
        }
        if (!poslana) {
            throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja nije nikada poslana!");
        }
        if (poruka.getStatusPoruke() == StatusPoruke.PROCITANA) {
            throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja je već pročitana!");
        }
        poruke.remove(poruka);
    }

    public void procitajPoruku(Poruka poruka) throws NeispravnaAkcija {
        boolean poslana = false;
        for (Poruka por : poruke) {
            if (poruka.equals(por)) {
                poslana = true;
                break;
            }
        }
        if (!poslana) {
            throw new NeispravnaAkcija("Nije moguće pročitati poruku koja nije nikada poslana!");
        }
        if (poruka.getStatusPoruke() == StatusPoruke.NEPROCITANA) {
            poruka.setStatusPoruke(StatusPoruke.PROCITANA);
        }
    }


    public void oznaciKaoNeprocitano(List<Poruka> porukeee) throws NeispravnaAkcija {
        boolean poslana = false;
        for (Poruka por : porukeee) {
            for (Poruka por2 : poruke) {
                if (por.equals(por2)) {
                    poslana = true;
                    break;
                } else {
                    poslana = false;
                }
            }
            if (poslana == false) {
                break;
            }
        }
        if (poslana == false) {
            throw new NeispravnaAkcija("Neke od poruka koje pokušavate označiti kao nepročitane nisu poslane!");
        }
        for (Poruka porrrr : porukeee) {
            porrrr.setStatusPoruke(StatusPoruke.NEPROCITANA);
        }
    }

    public Map<Korisnik, List<Poruka>> dajNeprocitanePoruke() {

        Map<Korisnik, List<Poruka>> mapa = new HashMap<>();

        for (Poruka por : poruke) {

            if (!mapa.containsKey(por.getPrimalac())) {
                mapa.put(por.getPrimalac(), new ArrayList<>());
            }
            if (por.getStatusPoruke() == StatusPoruke.NEPROCITANA) {
                mapa.get(por.getPrimalac()).add(por);
            }
        }
        return mapa;
    }


    public List<Poruka> dajPristiglePorukeZaKorisnika(Korisnik korisnik1) {
        List<Poruka> rez = new ArrayList<>();

        for (Poruka por : poruke) {
            if(por.getPrimalac().equals(korisnik1)){
                rez.add(por);
            }
        }
return rez;
    }

    public List<Poruka> dajPorukeZaKorisnika(Korisnik korisnik, StatusPoruke status) {
      return poruke.stream().filter(x-> x.getPrimalac().equals(korisnik)
              && x.getStatusPoruke().equals(status)).collect(Collectors.toList());
    }

    public List<Poruka> filtrirajPoruke(Function<Poruka, Boolean> f){
        return poruke.stream().filter(x->f.apply(x)).collect(Collectors.toList());
    }

    public List<Poruka> dajStarijeOd(Korisnik korisnik1, LocalDateTime datum) {
        return filtrirajPoruke(x->x.getPosiljalac().equals(korisnik1) && !x.getDatumSlanja().isAfter(datum));
    }

    @Override
    public String toString() {

        String s = "";
        for (Poruka poruka : poruke) {
            s += poruka + "\n";
        }
        return s.trim();

    }
}

