package br.edu.qi.projasigno;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Horoscopo {
    private String nome;
    private int anoNas, anoAt;
    private byte                
                diaNas,
                mesNas,
                diaAt,
                mesAt;
               
                  
  
    public int getAnoNas() {
        return anoNas;
    }
    public void setAnoNas(int anoNas) {
        this.anoNas = anoNas;
    }
    public int getAnoAt() {
        return anoAt;
    }
    public void setAnoAt(int anoAt) {
        this.anoAt = anoAt;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public byte getDiaNas() {
        return diaNas;
    }
    public void setDiaNas(byte diaNas) {
        this.diaNas = diaNas;
    }
    public byte getMesNas() {
        return mesNas;
    }
    public void setMesNas(byte mesNas) {
        this.mesNas = mesNas;
    }
    public byte getDiaAt() {
        return diaAt;
    }
    public void setDiaAt(byte diaAt) {
        this.diaAt = diaAt;
    }
    public byte getMesAt() {
        return mesAt;
    }
    public void setMesAt(byte mesAt) {
        this.mesAt = mesAt;
    }
    public boolean validarData(){
        int maxDias;
        switch (mesNas){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDias = 30;
                break;
            default:
                maxDias = anoNas % 4 == 0 && anoNas % 100 != 0 && anoNas % 400 == 0 && mesNas == 2 ? 29 : 28;
        }

        return
                 diaNas > 0 && diaNas <= maxDias &&
                 mesNas > 0 && mesNas <= 13 &&
                 anoNas > 0 && anoNas < 2100;
    }

    public String mostrarSigno(){
        String signo;
        switch(this.mesNas){
            
            case 1: signo = this.diaNas <= 20?"Capricórnio":"Aquário"; break;
            case 2: signo = this.diaNas <= 18?"Aquário":"Peixes"; break;
            case 3: signo = this.diaNas <= 19?"Peixes":"Áries"; break;
            case 4: signo = this.diaNas <= 20?"Áries":"Touro"; break;
            case 5: signo = this.diaNas <= 20?"Touro":"Gêmeos"; break;
            case 6: signo = this.diaNas <= 20?"Gêmeos":"Câncer"; break;
            case 7: signo = this.diaNas <= 21?"Câncer":"Leão"; break;
            case 8: signo = this.diaNas <= 22?"Leão":"Virgem"; break;
            case 9: signo = this.diaNas <= 22?"Virgem":"Libra"; break;
            case 10: signo = this.diaNas <= 22?"Libra":"Escorpião"; break;
            case 11: signo = this.diaNas <= 21?"Escorpião":"Sagitário"; break;
            case 12: signo = this.diaNas <= 21?"Sagitário":"Capricórnio"; break;
            default: signo = " ";

        }
        return signo;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String parabenizar(){
        String  dia, mes, ano, strData;
        
        LocalDate data = LocalDate.now();
        strData = String.valueOf(data);

        dia = strData.substring(8,10);
        diaAt = Byte.parseByte(dia);

        mes = strData.substring(5,7);
        mesAt = Byte.parseByte(mes);

        ano = strData.substring(2,4);
        anoAt = Byte.parseByte(ano);
        

        return diaAt == diaNas && mesAt == mesNas?"Feliz Aniversário!!!\n":"";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public byte calcularIdade(){
        String  dia, mes, ano, strData;
        int idade,res;
        LocalDate data = LocalDate.now();
        strData = String.valueOf(data);

        dia = strData.substring(8,10);
        diaAt = Byte.parseByte(dia);

        mes = strData.substring(5,7);
        mesAt = Byte.parseByte(mes);

        ano = strData.substring(2,4);
        anoAt = Byte.parseByte(ano);

        idade = anoAt;
        idade-= anoNas;
        res = idade < 0? 100 + idade: idade;

        if(mesNas > mesAt ){            
                res -=1;
        }else if(mesNas == mesAt && diaNas > diaAt){
            res -=1;
        }
        

        return (byte)res;
        
    }



    @NonNull
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String toString() {
        if(validarData()) {
            return
                    parabenizar() +
                            this.nome + ", sua idade é " + calcularIdade() + "\n" +
                            "Seu aniversário é  " + this.diaNas + " / " + this.mesNas + "\n" +
                            "Seu signo é " + mostrarSigno();
        }else {
            return  " Dados inválidos!";
        }
    }
    

}
