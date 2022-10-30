package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AddToBalanceStrategy;
import core.basesyntax.strategy.FruitShopTransaction;
import core.basesyntax.strategy.PurchaseStrategy;

public class FruitShopTransactionImpl implements FruitShopTransaction {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private final AddToBalanceStrategy addToBalanceStrategy;
    private final PurchaseStrategy purchaseStrategy;

    public FruitShopTransactionImpl() {
        addToBalanceStrategy = new AddToBalanceStrategyImpl();
        purchaseStrategy = new PurchaseStrategyImpl();
    }

    @Override
    public void fruitTransaction(String activityType, String fruit, Integer quantity) {
        checkFruit(fruit);
        checkQuantity(quantity);
        switch (activityType) {
            case BALANCE:
            case SUPPLY:
            case RETURN:
                addToBalanceStrategy.action(fruit, quantity);
                break;
            case PURCHASE:
                purchaseStrategy.action(fruit, quantity);
                break;
            default: throw new RuntimeException("Invalid activity type!");
        }
    }

    private void checkFruit(String fruit) throws RuntimeException {
        if (fruit == null) {
            throw new RuntimeException("Null fruit");
        }
    }

    private void checkQuantity(Integer quantity) throws RuntimeException {
        if (quantity == null) {
            throw new RuntimeException("Null quantity");
        }
    }
}
