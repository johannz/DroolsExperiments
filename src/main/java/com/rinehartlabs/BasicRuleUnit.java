package com.rinehartlabs;

import com.rinehartlabs.dto.Stat;
import com.rinehartlabs.dto.StatModifier;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

@SuppressWarnings("unused")
public class BasicRuleUnit implements RuleUnitData {
    private final DataStore<Stat> statPoints;
    private final DataStore<StatModifier> modifiers;
    private final DataStore<Stat> stats;

    public BasicRuleUnit() {
        this(DataSource.createStore(), DataSource.createStore(), DataSource.createStore());
    }

    public BasicRuleUnit(DataStore<Stat> statPoints, DataStore<StatModifier> modifiers, DataStore<Stat> stats) {
        this.statPoints = statPoints;
        this.modifiers = modifiers;
        this.stats = stats;
    }

    public DataStore<Stat> getStatPoints() {
        return statPoints;
    }

    public DataStore<StatModifier> getModifiers() {
        return modifiers;
    }

    public DataStore<Stat> getStats() {
        return stats;
    }
}
