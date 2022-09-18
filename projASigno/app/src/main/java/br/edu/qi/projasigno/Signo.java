package br.edu.qi.projasigno;

import java.time.LocalDate;
import java.util.Date;

public class Signo {
    private String nome;
    private double idade;
    private byte diaNasci,mesNasci;
    private int anoNasci;
    private byte dia, mes;
    private int ano;


    public byte getDiaNasci() {
        return diaNasci;
    }

    public void setDiaNasci(byte diaNasci) {
        this.diaNasci = diaNasci;
    }

    public byte getMesNasci() {
        return mesNasci;
    }

    public void setMesNasci(byte mesNasci) {
        this.mesNasci = mesNasci;
    }

    public int getAnoNasci() {
        return anoNasci;
    }

    public void setAnoNasci(int anoNasci) {
        this.anoNasci = anoNasci;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getDia() {
        return dia;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public byte getMes() {
        return mes;
    }

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public boolean validarData() {
        return (this.dia >= 1 && this.dia <= 31 && this.ano > 0) && ((this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12)|| ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && this.dia <= 30) || (this.mes == 2 && (this.dia <= 29 && (this.ano % 4 == 0 && this.ano % 100 != 0) || this.ano % 400 == 0 ) || this.dia <= 28));
    }

}
