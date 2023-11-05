public class Registro {
    private Integer key;
    private Integer valor;
    private Registro next;

    public Registro(Integer key, Integer valor) {
        this.key = key;
        this.valor = valor;
        this.next = null;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValor() {
        return this.valor;
    }

    public Registro getNext() {
        return this.next;
    }

    public void setNext(Registro next) {
        this.next = next;
    }
}