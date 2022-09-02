package stream;

public class A {
    private String name;
    private String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

/*    @Override
    public boolean equals(Object obj) {
        if (obj instanceof A) {
            A tmp = (A) obj;
            if (this.getName().equals(tmp.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 17 * result;
        return result;
    }*/
}
