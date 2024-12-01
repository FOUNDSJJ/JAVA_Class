import java.lang.Integer;
import java.lang.Object;
import java.util.Objects;

public class RecordDemo {

    public record Product(Integer id,String name,double price){

        public Product(Integer id){
            this(id,"Product",12.8);
        }

        @Override
        public boolean equals(Object obj){
            if(this==obj)
                return true;
            if(!(obj instanceof Product objProduct))
                return false;
            return Objects.equals(objProduct.id, this.id)
                    &&Objects.equals(objProduct.name, this.name) &&Objects.equals(objProduct.price, this.price) ;
        }

        @Override
        public int hashCode(){
            return Objects.hash(id,name,price);
        }

        @Override
        public String toString(){
            return "id: "+id+"  name: "+name+"  price: "+price;
        }

    }

    public static void main(String[] args){
        Product p1=new Product(123);
        Product p2=new Product(321);
        Product p3=new Product(321);
        System.out.println("p1: "+p1.toString());
        System.out.println("p1.hashCode: "+p1.hashCode());
        System.out.println("p2: "+p2.toString());
        System.out.println("p2.hashCode: "+p2.hashCode());
        System.out.println("p3: "+p3.toString());
        System.out.println("p3.hashCode: "+p3.hashCode());
        System.out.println("p1.equals(p3): "+p1.equals(p3));
        System.out.println("p2.equals(p3): "+p2.equals(p3));
    }

}
