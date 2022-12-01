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

            basicRuleUnit.getStatPoints().add(new Stat(STRENGTH, 0));
            basicRuleUnit.getStatPoints().add(new Stat(DEXTERITY, 0));

            basicRuleUnit.getModifiers().add(new StatModifier(STRENGTH, "racial", -1));
            basicRuleUnit.getModifiers().add(new StatModifier(DEXTERITY, "racial", -2));

            instance.fire();

            System.out.println("---");
            instance.executeQuery("FindStats").toList().forEach(System.out::println);
            System.out.println("---");

            basicRuleUnit.getModifiers().add(new StatModifier(STRENGTH, "spell", 2));
            basicRuleUnit.getModifiers().add(new StatModifier(DEXTERITY, "spell", -2));
            instance.fire();

            System.out.println("---");
            instance.executeQuery("FindStats").toList().forEach(System.out::println);
            System.out.println("---");

        }
    }
}