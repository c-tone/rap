package ctone.rap.db.module.plan;

/**
 * Created by ouyi on 2017/2/17.
 * 预算
 */
public class Budget {
    private double fee;
    private Unit unit;
    private String description;

    private enum Unit{
        RMB("￥"),
        USD("$"),
        ;
        private String symbol;
        Unit(String symbol) {
            this.symbol = symbol;
        }
        public String getSymbol() {
            return symbol;
        }
    }


}
