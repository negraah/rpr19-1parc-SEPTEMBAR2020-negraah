package ba.unsa.etf.rpr;

import java.time.LocalDateTime;


public class Poruka {
    private Korisnik posiljalac;
    private Korisnik primalac;
    private LocalDateTime datumSlanja;
    private String tekst;
    private StatusPoruke statusPoruke;


    public Poruka(Korisnik posiljalac, Korisnik primilac, LocalDateTime datumSlanja, String tekst) throws NeispravanFormatPoruke {
        if(posiljalac==null){
            throw new NeispravanFormatPoruke("Pošiljalac ne smije biti null!");
        }else if(primilac==null){
            throw new NeispravanFormatPoruke("Primalac ne smije biti null!");
        }else if(tekst==null){
            throw new NeispravanFormatPoruke("Tekst ne smije biti null!");
        }else if(tekst=="") {
            throw new NeispravanFormatPoruke("Tekst ne smije biti prazan!");
        }else if(datumSlanja==null){
            throw new NeispravanFormatPoruke("Datum slanja ne smije biti null!");
        }else  {
            this.posiljalac = posiljalac;
            this.primalac = primilac;
            this.datumSlanja = datumSlanja;
            this.tekst = tekst;
            StatusPoruke statusPoruke = StatusPoruke.NEPROCITANA;
        }
    }

    public Korisnik getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Korisnik posiljalac) throws NeispravanFormatPoruke {
        if(posiljalac==null){
            throw new NeispravanFormatPoruke("Pošiljalac ne smije biti null!");}
        this.posiljalac = posiljalac;
    }

    public Korisnik getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Korisnik primilac) throws NeispravanFormatPoruke {
        if(primilac==null){
            throw new NeispravanFormatPoruke("Primalac ne smije biti null!");}
        this.primalac = primilac;
    }

    public LocalDateTime getDatumSlanja() {
        return datumSlanja;
    }

    public void setDatumSlanja(LocalDateTime datumSlanja) throws NeispravanFormatPoruke {
        if(datumSlanja==null){
            throw new NeispravanFormatPoruke("Datum slanja ne smije biti null!");}
        this.datumSlanja = datumSlanja;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) throws NeispravanFormatPoruke {
        if(tekst==""){
            throw new NeispravanFormatPoruke("Tekst ne smije biti prazan!");
        }
        if(tekst==null){
            throw new NeispravanFormatPoruke("Tekst ne smije biti null");}
        this.tekst = tekst;
    }

    public StatusPoruke getStatusPoruke() {
        return statusPoruke;
    }

    public void setStatusPoruke(StatusPoruke statusPoruke) {
        this.statusPoruke = statusPoruke;
    }

    @Override
    public String toString() {
        return "[od: " +getPosiljalac() +" za: "+ getPrimalac() +" tekst: "+ getTekst() +"]";
    }


}
