package org.ayahiro.practice.design_patterns.creational.builder;

/**
 * @Author ayahiro
 * @Description: 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * @Create: 2019/7/15
 */
public class Builder {
    public static void main(String[] args) {
        CharacterPanel characterPanel = new CharacterPanel();
        Character swordsman = characterPanel.createCharacter(new SwordsmanBuilder());
        Character gunner = characterPanel.createCharacter(new GunnerBuilder());
        swordsman.show();
        gunner.show();
    }
}

//Product
class Character {
    String weapon;
    String guard;

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public void show() {
        System.out.println("这个角色的武器是：" + weapon + "，防具精通：" + guard);
    }
}

//Builder
interface CharacterBuilder {
    void buildWeapon();

    void buildGuard();

    Character createCharacter();
}

//ConcreteBuilder1
class SwordsmanBuilder implements CharacterBuilder {
    Character character = new Character();

    @Override
    public void buildWeapon() {
        character.setWeapon("残破的剑");
    }

    @Override
    public void buildGuard() {
        character.setGuard("重甲");
    }

    @Override
    public Character createCharacter() {
        return character;
    }
}

//ConcreteBuilder2
class GunnerBuilder implements CharacterBuilder {
    Character character = new Character();

    @Override
    public void buildWeapon() {
        character.setWeapon("没子弹的枪");
    }

    @Override
    public void buildGuard() {
        character.setGuard("皮甲");
    }

    @Override
    public Character createCharacter() {
        return character;
    }
}

//Director
class CharacterPanel {
    public Character createCharacter(CharacterBuilder characterBuilder) {
        characterBuilder.buildWeapon();
        characterBuilder.buildGuard();
        return characterBuilder.createCharacter();
    }
}