package br.com.fiap;

public class Jogador {
    
    private String nome;
    private int xp;
    private int hp;
    private boolean envenenado;

    public Jogador(){}

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void receberAntídoto(){
        if(isEnvenenado())
            envenenado = false;
        
        envenenado = true;
    }
    
    public void atacar(Jogador jogador){

        jogador.receberDano(jogador.xp);

        if(jogador.getHp() <= 0)
            this.ganharExperiencia(jogador.xp);
    }

    public void receberDano(int pontos){
        hp -= pontos;
        if(getHp() <= 0)
            System.out.println("GAME OVER "+ getNome());
    }

    public void receberCura(int pontos){
        hp += pontos;
    }

    public void ganharExperiencia(int pontos){
        xp += pontos;
    }
    
    public int getHp() {
        return hp;
    }   

    public String getNome() {
        return nome;
    }

    public int getXp() {
        return xp;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

}
