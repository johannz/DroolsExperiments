package com.rinehartlabs;

import com.rinehartlabs.dto.Stat;
import com.rinehartlabs.dto.StatModifier;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

import static com.rinehartlabs.dto.StatType.DEXTERITY;
import static com.rinehartlabs.dto.StatType.STRENGTH;

public class Main {
    public static void main(String[] args) {
        try (RuleUnitInstance<BasicRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(new BasicRuleUnit())) {
            BasicRuleUnit basicRuleUnit = instance.ruleUnitData();
            Stat strength = new Stat(STRENGTH);
            Stat dexterity = new Stat(DEXTERITY);
            StatModifier strRace = new StatModifier(STRENGTH, "racial", 1);
            StatModifier strSpell = new StatModifier(STRENGTH, "spell", 2);
            StatModifier dexRace = new StatModifier(DEXTERITY, "racial", 2);

            basicRuleUnit.getStats().add(strength);
            basicRuleUnit.getStats().add(dexterity);
            basicRuleUnit.getModifiers().add(strRace);
            basicRuleUnit.getModifiers().add(strSpell);
            basicRuleUnit.getModifiers().add(dexRace);

            instance.fire();
            System.out.println("---");
            System.out.println(strength);
            System.out.println(dexterity);
            System.out.println("---");
        }
    }
}