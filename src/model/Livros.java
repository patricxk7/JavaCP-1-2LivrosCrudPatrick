package model;

public class Livros {

    private int id;
    private String titulo;
    private String escritor;
    private int anoLancamento;
    private String genero;
    private double notas;

    public Livros() {
    }

    public Livros(String titulo, String escritor, int anoLancamento,
                  String genero, double notas) {

        this.titulo = titulo;
        this.escritor = escritor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", escritor='" + escritor + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                ", notas=" + notas +
                '}';
    }
}