package com.rinehartlabs;

import com.rinehartlabs.dto.StatModifier;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

import static com.rinehartlabs.dto.StatType.DEXTERITY;
import static com.rinehartlabs.dto.StatType.STRENGTH;

public class Main {
    public static void main(String[] args) {
        StatModifier goblinStrModifier = new StatModifier(STRENGTH, "racial", -1);
        StatModifier goblinDexModifier = new StatModifier(DEXTERITY, "racial", 1);

        StatModifier orcStrModifier = new StatModifier(STRENGTH, "racial", 1);
        StatModifier orcDexModifier = new StatModifier(DEXTERITY, "racial", -1);

        try (RuleUnitInstance<BasicRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(new BasicRuleUnit())) {
            BasicRuleUnit basicRuleUnit = instance.ruleUnitData();

            System.out.println("---");
            instance.fire();
            System.out.println("---");

            basicRuleUnit.getModifiers().add(goblinStrModifier);
            basicRuleUnit.getModifiers().add(goblinDexModifier);

            System.out.println("---");
            instance.fire();
            System.out.println("---");

            basicRuleUnit.getModifiers().add(orcStrModifier);
            basicRuleUnit.getModifiers().add(orcDexModifier);
            basicRuleUnit.getModifiers().remove(goblinStrModifier);
            basicRuleUnit.getModifiers().remove(goblinDexModifier);

            System.out.println("---");
            instance.fire();
            System.out.println("---");


            System.out.println("---");
            instance.executeQuery("FindStats").toList().forEach(System.out::println);
            System.out.println("---");
        }
    }
}