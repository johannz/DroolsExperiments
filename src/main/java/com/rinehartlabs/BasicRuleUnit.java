package com.rinehartlabs;

import com.rinehartlabs.dto.Stat;
import com.rinehartlabs.dto.StatModifier;
import com.rinehartlabs.dto.StatPoint;
import com.rinehartlabs.dto.StatType;
import org.drools.ruleunits.api.DataHandle;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

import java.util.EnumMap;
import java.util.Map;

import static com.rinehartlabs.dto.StatType.DEXTERITY;
import static com.rinehartlabs.dto.StatType.STRENGTH;

@SuppressWarnings("unused")
public class BasicRuleUnit implements RuleUnitData {
    private final DataStore<StatPoint> statPoints;
    private final DataStore<StatModifier> modifiers;
    private final DataStore<Stat> stats;

    private final Map<StatType, DataHandle> statPointHandles = new EnumMap<>(StatType.class);

    public BasicRuleUnit() {
        this(DataSource.createStore(), DataSource.createStore(), DataSource.createStore());
    }

    public BasicRuleUnit(DataStore<StatPoint> statPoints, DataStore<StatModifier> modifiers, DataStore<Stat> stats) {
        this.statPoints = statPoints;
        this.modifiers = modifiers;
        this.stats = stats;

        setStatPoint(STRENGTH, 5);
        setStatPoint(DEXTERITY, 6);
    }

    public DataStore<StatPoint> getStatPoints() {
        return statPoints;
    }

    public DataStore<StatModifier> getModifiers() {
        return modifiers;
    }

    public DataStore<Stat> getStats() {
        return stats;
    }

    public void setStatPoint(StatType type, int value) {
        StatPoint statPoint = new StatPoint(type, value);
        statPointHandles.compute(type, (k, v) -> {
            if (v == null) {
                return statPoints.add(statPoint);
            } else {
                statPoints.update(v, statPoint);
                return v;
            }
        });
    }
}
