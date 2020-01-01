# League-of-OOP
Copyright Sebastian Samoilescu 2019

|--------------------------------|
|   Nume:  Sebastian Samoilescu  |
|   Grupa: 325CA                 |
|--------------------------------|

++++++++++++++ ETAPA I ++++++++++++++++++

EROI
---> pentru implementarea eroilor am folosit clasa de baza Character care a fost ulterior
     extinsa de cei 4 eroi

ABILITATI
---> pentru fiecare erou se observa ca are 2 tipuri de abilitati(baseAbility si specialAbility)

---> clasa de baza ability a fost extinsa de cele 4 baseAbilities, de specialAbility.
     SpecialAbility este si ea extinsa de cele 4 specialAbilities.

---> o abilitate este de tip specialAbility daca ofera damage prelungit sau paralysis

---> intre clasele Character si ability se stabileste o relatie de compunere.

LOCATION
---> harta este realizata cu ajutorul unei matrici in care fiecare element este de tip cell

---> clasa cell este extinsa de cele 4 tipuri ce teren

FACTORIES
---> pentru a creea usor noi instante de Character, ability, Cell am implementat pentru fiecare
     clase de tip factory


DOUBLE DISPATCH
---> pattern -ul visitor a fost implementat in 2 contexte:

    1) Pentru ca un player sa obtina bonusul de teren
    2) Pentru ca un player sa accepta o abilitate de la un alt player
   
1) ---> in prima situatie elementul ce accepta vizita este clasa Cell, cu clasele copil(Volcanic, Woods, etc)
        sunt concrete elements, iar visitor - ul este reprezentat de clasa Character, cu clasele copil ca 
        fiind concrete visitors. 
   
   ---> metoda "sendBonus()" este o metoda de tip "accept()", iar metoda "setLocationBonus()" este o metoda
        de tip "visit()"

2)  ---> in cea de-a doua situatie elementl ce accepta vizita este clasa ability, cu clasele copil fiind
        concrete elements, iar visitor - ul este reprezentat de clasa Character, cu clasele copil ca 
        fiind concrete visitors. 
   
   ---> metoda "strike()" este o metoda de tip "accept()", iar metoda "acceptAbility()" este o metoda
        de tip "visit()"

LOGICA JOCULUI
---> este realizata cu ajutorul clasei GameEngine

CITIREA DATELOR
---> este realizata cu ajutorul clasei GameInputLoader


++++++++++++ Etapa II +++++++++++++++++

INGERI

-----> pentru fiecare tip de inger a fost realizata o clasa ce mosteneste clasa principala "Angel"

-----> am folosit patter - ul visitor intre ingeri si caractere (pentru a acorda bonusurile corespunzatoare)


OBSERVER

-----> observer - ul este reprezentat de clasa GreatWizard care implementeaza interfata Observer definita de mine
       marele magician detine metoda de update, metoda ce printeaza detalii despre o stare furnizata de obiectele
       observate

-----> obiectele observate sunt atat caracterele jocului cat si ingerii

-----> fiecare obiect observat este caracterizat de o stare si de o functie ce alerteaza observatorul atunci cand
       starea obiectului se schimba


STRATEGII

----> pentru implementarea strategiilor am introdus un camp nou in clasa "character", un obiect de tip "Strategy"

----> exista doua tipuri de strategii (damageStrategy si hpStrategy) ce implementeaza interfata Stratgy.
				     === damage strategy - renuntare la viata si crestere modificatori dmg
				     === hp strategy - renuntare la modificatori dmg si crestere viata

RUNDE

----> ingerii, precum si miscarile pentru fiecare runda sunt retinute intr - o noua clasa "Round"
