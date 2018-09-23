package ru.rougegibbons.landsanddungeons.components.core.numbers.modifiable.floatpoint;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.landsanddungeons.components.core.numbers.modifiable.generic.ModifiableClampedNumberComponentImpl;
import ru.rougegibbons.landsanddungeons.components.interfaces.core.numbers.ModifiableClampedNumberComponent;
import ru.rougegibbons.landsanddungeons.components.models.ComponentModel;
import ru.rougegibbons.landsanddungeons.components.models.core.numbers.ClampedFloatComponentModel;
import ru.rougegibbons.landsanddungeons.utils.constants.Constants;
import ru.rougegibbons.landsanddungeons.utils.proxies.ArithmeticsProxy;
import ru.rougegibbons.landsanddungeons.utils.proxies.FloatArithmeticsProxyImpl;
import ru.rougegibbons.landsanddungeons.utils.proxies.FloatTrimmerProxyImpl;
import ru.rougegibbons.landsanddungeons.utils.proxies.TrimmerProxy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link ModifiableClampedNumberComponentImpl} class extension for {@link Float} numbers.
 *
 * @see ModifiableClampedNumberComponentImpl
 * @see ModifiableClampedNumberComponent
 * @see ComponentModel
 * @see ClampedFloatComponentModel
 * @see ArithmeticsProxy
 * @see TrimmerProxy
 * @see Float
 * @since 0.3.5
 */
public class ModifiableClampedFloatComponentImpl extends ModifiableClampedNumberComponentImpl<Float>
        implements ModifiableClampedNumberComponent.ModifiableClampedFloatComponent {
    private static final AtomicLong INSTANCE_COUNTER = new AtomicLong(Constants.ZERO_LONG);

    private static final ArithmeticsProxy.FloatArithmeticsProxy ARITHMETICS_PROXY =
            new FloatArithmeticsProxyImpl();
    private static final TrimmerProxy.FloatTrimmerProxy TRIMMER_PROXY = new FloatTrimmerProxyImpl();

    /**
     * constructor for creating new components with preinitialized current value.
     *
     * @param lowerBoundary - lower boundary.
     * @param upperBoundary - upper boundary.
     */
    public ModifiableClampedFloatComponentImpl(@NotNull Float lowerBoundary,
                                               @NotNull Float upperBoundary) {
        super(lowerBoundary, upperBoundary);
    }

    /**
     * constructor for creating new components with given current value.
     *
     * @param lowerBoundary - lower boundary.
     * @param upperBoundary - upper boundary.
     * @param currentValue  - current value.
     */
    public ModifiableClampedFloatComponentImpl(@NotNull Float lowerBoundary,
                                               @NotNull Float upperBoundary,
                                               @NotNull Float currentValue) {
        super(lowerBoundary, upperBoundary, currentValue);
    }

    /**
     * constructor for deserialization from {@link ClampedFloatComponentModel} data model instance.
     *
     * @param model - {@link ClampedFloatComponentModel} data model instance with component data.
     */
    public ModifiableClampedFloatComponentImpl(@NotNull ClampedFloatComponentModel model) {
        super(model.getId(), model.getLowerBoundary(),
                model.getUpperBoundary(), model.getCurrentValue());
    }

    /**
     * serializes component into {@link ClampedFloatComponentModel} data model instance.
     *
     * @return {@link ClampedFloatComponentModel} data model instance with component data.
     */
    @Override
    public @NotNull ComponentModel pack() {
        return new ClampedFloatComponentModel(getId(), getLowerBoundary(),
                getUpperBoundary(), getCurrentValue());
    }

    /**
     * instance id generator to be used in {@link ru.rougegibbons.landsanddungeons.components.core.AbstractComponent}.
     *
     * @return generated instance id.
     */
    @Override
    protected @NotNull Long initId() {
        return INSTANCE_COUNTER.getAndIncrement();
    }

    /**
     * see {@link ModifiableClampedNumberComponentImpl} description.
     *
     * @return {@link ArithmeticsProxy.FloatArithmeticsProxy} implementation instance.
     */
    @Override
    protected @NotNull ArithmeticsProxy.FloatArithmeticsProxy getArithmeticsProxy() {
        return ARITHMETICS_PROXY;
    }

    /**
     * see {@link ModifiableClampedNumberComponentImpl} description.
     *
     * @return {@link TrimmerProxy.FloatTrimmerProxy} implementation instance.
     */
    @Override
    protected @NotNull TrimmerProxy.FloatTrimmerProxy getTrimmerProxy() {
        return TRIMMER_PROXY;
    }
}
