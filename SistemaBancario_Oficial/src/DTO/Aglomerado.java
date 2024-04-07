/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Dark Blue
 */
public class Aglomerado {
   public boolean User(String nome,int senha)
   {
        String nomeUser = nome;
        int senhaUser = senha;
        if("Nossir".equals(nomeUser)&& senhaUser==1234)
        {
            return true;
        }
        else if("Haya".equals(nomeUser)&&senhaUser==1212)
        {
            return true;
        }
        else if("Yato".equals(nomeUser)&&senhaUser==1111)
        {
            return true;
        }
        else if("Kochi".equals(nomeUser)&&senhaUser==1251)
        {
            return true;
        }
        else
            return false;
    } 
public void criarConta(String nome,String endereco,String nif,String data,String email,String sexo, int valorInicial, String IBAN, int id_Cliente,int telefone)
    {
        String cadastroNome[] = new String[100];
        String cadastroEndereco[]= new String[100];
        String cadastroNif[] = new String[100];
        String cadastroData[] = new String[100];
        String cadastroEmail[] = new String[100];
        String cadastroSexo[] = new String[100];
        int cadastroId_Cliente[] = new int[100];
        int cadastroTelefone[] = new int[100];
        String cadastroIBAN[] = new String[100];
        int cadastroValorInicial[] = new int[100];
        int num=0;
        while(num<=10)
        {
            cadastroNome[num]= nome;
            cadastroEndereco[num]=endereco;
            cadastroNif[num] = nif;
            cadastroData[num] = data;
            cadastroEmail[num] = email;
            cadastroSexo[num] = sexo;
            cadastroId_Cliente[num] = id_Cliente;
            cadastroTelefone[num] = telefone;
            cadastroIBAN[num] = IBAN;
            cadastroValorInicial[num] = valorInicial;
            num++;
        }   
    }
public void criarContaPoupanca(String nome,String endereco,String nif,String data,String email,String sexo, 
        int valorInicial, String IBAN, int id_Cliente,int telefone,
        int variacao, int limite)
    {
        String cadastroNome[] = new String[100];
        String cadastroEndereco[]= new String[100];
        String cadastroNif[] = new String[100];
        String cadastroData[] = new String[100];
        String cadastroEmail[] = new String[100];
        String cadastroSexo[] = new String[100];
        int cadastroId_Cliente[] = new int[100];
        int cadastroTelefone[] = new int[100];
        String cadastroIBAN[] = new String[100];
        int cadastroValorInicial[] = new int[100];
        int cadastroVariacao[] = new int[100];
        int cadastroLimite[] = new int[100];
        int num=0;
        while(num<=10)
        {
            cadastroNome[num]= nome;
            cadastroEndereco[num]=endereco;
            cadastroNif[num] = nif;
            cadastroData[num] = data;
            cadastroEmail[num] = email;
            cadastroSexo[num] = sexo;
            cadastroId_Cliente[num] = id_Cliente;
            cadastroTelefone[num] = telefone;
            cadastroIBAN[num] = IBAN;
            cadastroValorInicial[num] = valorInicial;
            num++;
        }   
    }

}
/*cadastroVariacao[num] = variacao;
            cadastroLimite[num] = limite;
            */