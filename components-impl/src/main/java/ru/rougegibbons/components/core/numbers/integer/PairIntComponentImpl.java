package ru.rougegibbons.components.core.numbers.integer;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.components.core.numbers.generic.PairNumberComponentImpl;
import ru.rougegibbons.components.interfaces.core.PairNumberComponent;
import ru.rougegibbons.components.models.ComponentModel;
import ru.rougegibbons.components.models.core.PairIntComponentModel;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;

import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link PairNumberComponentImpl} extension for {@link Integer} numbers only.
 * @see PairNumberComponentImpl
 * @see PairNumberComponent
 * @see PairNumberComponent.PairIntComponent
 * @see Integer
 */
public class PairIntComponentImpl extends PairNumberComponentImpl<Integer>
        implements PairNumberComponent.PairIntComponent {
    private static final AtomicLong INSTANCE_COUNTER = new AtomicLong(Constants.ZERO_LONG);

    /**
     * constructor for creating new component.
     * @param firstValue - first value to be stored.
     * @param secondValue - second value to be stored.
     */
    public PairIntComponentImpl(@NotNull Integer firstValue,
                                @NotNull Integer secondValue) {
        super(firstValue, secondValue);
    }

    /**
     * constructor for deserialization from {@link PairIntComponentModel} data model.
     * @param model - data model containing component's data.
     */
    public PairIntComponentImpl(@NotNull PairIntComponentModel model) {
        super(model.getId(), model.getFirstValue(), model.getSecondValue());
    }

    /**
     * serialize component's data into {@link PairIntComponentModel} data model.
     * @return data model.
     */
    @Override
    public @NotNull ComponentModel pack() {
        return new PairIntComponentModel(getId(), getFirstValue(), getSecondValue());
    }

    /**
     * instance id generator to be used in {@link ru.rougegibbons.components.core.AbstractComponent} constructor.
     * @return generated instance id.
     */
    @Override
    public @NotNull Long initId() {
        return INSTANCE_COUNTER.getAndIncrement();
    }
}