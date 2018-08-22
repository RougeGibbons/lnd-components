package ru.rougegibbons.components.core.numbers.longint;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.components.core.numbers.generic.PairNumberComponentImpl;
import ru.rougegibbons.components.interfaces.core.PairNumberComponent;
import ru.rougegibbons.components.models.ComponentModel;
import ru.rougegibbons.components.models.core.PairLongComponentModel;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;

import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link PairNumberComponentImpl} extension for {@link Long} numbers only.
 * @see PairNumberComponentImpl
 * @see PairNumberComponent
 * @see PairNumberComponent.PairLongComponent
 * @see Long
 */
public class PairLongComponentImpl extends PairNumberComponentImpl<Long>
        implements PairNumberComponent.PairLongComponent {
    private static final AtomicLong INSTANCE_COUNTER = new AtomicLong(Constants.ZERO_LONG);

    /**
     * constructor for creating a new component.
     * @param firstValue - first value to be stored.
     * @param secondValue - second value to be stored.
     */
    public PairLongComponentImpl(@NotNull Long firstValue,
                                 @NotNull Long secondValue) {
        super(firstValue, secondValue);
    }

    /**
     * constructor for deserialization from {@link PairLongComponentModel} data model.
     * @param model - data model containing component's data.
     */
    public PairLongComponentImpl(@NotNull PairLongComponentModel model) {
        super(model.getId(), model.getFirstValue(), model.getSecondValue());
    }

    /**
     * serializes component data into {@link PairLongComponentModel} data model.
     * @return data model containing component's data.
     */
    @Override
    public @NotNull ComponentModel pack() {
        return new PairLongComponentModel(getId(), getFirstValue(), getSecondValue());
    }

    /**
     * instance ids generator to be used in {@link ru.rougegibbons.components.core.AbstractComponent} constructor.
     * @return generated instance id.
     */
    @Override
    protected @NotNull Long initId() {
        return INSTANCE_COUNTER.getAndIncrement();
    }
}