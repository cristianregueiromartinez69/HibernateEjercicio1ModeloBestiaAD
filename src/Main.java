import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
            Crud crud = new Crud();

            crud.createComponentes("luis","perez", BigDecimal.valueOf(2000.4));
            crud.createComponentes("ana","suarez", BigDecimal.valueOf(2100.427));
            crud.createComponentes("pedro","aguinho", BigDecimal.valueOf(1500.6123254));

            crud.readComponentes("pedro");

            crud.updateComponentes("ana","bermejo", BigDecimal.valueOf(3450.1287));

            crud.deleteComponentes("luis");
    }
}