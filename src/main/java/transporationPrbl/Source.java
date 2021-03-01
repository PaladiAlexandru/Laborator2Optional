package transporationPrbl;

import java.util.Objects;

/**
 * Clasa de baza pentru toate tipurile de sursa
 */
public abstract class Source {
    protected String name;
    protected int capacity;


    public Source(String name, int capacity) {

        this.name = name;
        this.capacity = capacity;

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return name.equals(source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
