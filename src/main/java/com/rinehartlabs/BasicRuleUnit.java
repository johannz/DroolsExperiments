package com.rinehartlabs;

import com.rinehartlabs.dto.Stat;
import com.rinehartlabs.dto.StatModifier;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class BasicRuleUnit implements RuleUnitData {
    private final DataStore<Stat> stats;
    private final DataStore<StatModifier> modifiers;

    public BasicRuleUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public BasicRuleUnit(DataStore<Stat> stats, DataStore<StatModifier> modifiers) {
        this.stats = stats;
        this.modifiers = modifiers;
    }

    public DataStore<Stat> getStats() {
        return stats;
    }

    public DataStore<StatModifier> getModifiers() {
        return modifiers;
    }
}
