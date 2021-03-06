package ru.rougegibbons.landsanddungeons.components.core.numbers.constant.longint;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.components.core.AbstractComponent;
import ru.rougegibbons.landsanddungeons.components.core.numbers.constant.generic.SingleNumberComponentImpl;
import ru.rougegibbons.landsanddungeons.components.interfaces.core.numbers.SingleNumberComponent;
import ru.rougegibbons.landsanddungeons.components.models.ComponentModel;
import ru.rougegibbons.landsanddungeons.components.models.core.numbers.SingleLongComponentModel;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;

import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link Long} integers implementation of {@link SingleNumberComponentImpl}.
 * @see SingleNumberComponent
 * @see SingleNumberComponentImpl
 */
public class SingleLongComponentImpl extends SingleNumberComponentImpl<Long>
        implements SingleNumberComponent.SingleLongComponent {
    private static final AtomicLong INSTANCE_COUNTER = new AtomicLong(Constants.ZERO_LONG);

    /**
     * constructor for unpacking from resource file/packet.
     * @param model - data model
     * @see SingleLongComponentModel
     */
    public SingleLongComponentImpl(@NotNull SingleLongComponentModel model) {
        super(model.getId(), model.getValue());
    }

    /**
     * overloaded constructor from {@link SingleNumberComponentImpl}.
     * @param value value to be stored.
     */
    public SingleLongComponentImpl(@NotNull Long value) {
        super(value);
    }

    /**
     * packs stored data into {@link SingleLongComponentModel} data model.
     * @return data model.
     */
    @Override
    public @NotNull ComponentModel pack() {
        return new SingleLongComponentModel(getId(), getValue());
    }

    /**
     * instance id generator to be used in {@link AbstractComponent} constructor.
     * @return generated id.
     */
    @Override
    protected @NotNull Long initId() {
        return INSTANCE_COUNTER.getAndIncrement();
    }
}
