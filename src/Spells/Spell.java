package Spells;
import Character.Character;
import Weapons.Weapons;

public class Spell {
    protected final String spellName;
    protected final int coolDawn;

    protected int coolDawnRemaining;

    public Spell(String spellName, int coolDawn) {
        this.spellName = spellName;
        this.coolDawn = coolDawn;
        this.coolDawnRemaining = 0;
    }

    public String getSpellName() {
        return spellName;
    }

    public void cast (Character enemy) {
        if (coolDawnRemaining > 0 ) {
            throw new MyRuntimeException("Spell is not ready yet");
        }
        coolDawnRemaining = coolDawn;
    }
    public void apply(Character target) {
        if (coolDawnRemaining > 0 ) {
            throw new MyRuntimeException("Spell is not ready yet");
        }
        coolDawnRemaining = coolDawn;
    }
    public void apply(Character target, Weapons[] weapon){}
    public void unapply() {};
    public void spellCounter () {
        if (coolDawnRemaining > 0 ) {
            --coolDawnRemaining;
        }
    }
    public void dmgCounter (Character target){}
    public void debuffCounter (Character target){}
    public void debuffCounter (Character target, Weapons[] weapon){}

}
