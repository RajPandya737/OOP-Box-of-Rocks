//Name: Raj Pandya
//Date: January 14, 2022
//Purpose: To create a card-game for Ms. McGonagall grade 4-5 class. The purpose of this class is to create a card class for Box of Rocks
package com.example.pandyarajbor;

public class Card {
    private String question;
    //Question global instance variable, holds the actual question. In string format
    private int answer;
    //Answer global instance variable. holds the answer to the question in int format
    private String reason;
    //The reason behind why the answer is the answer. In string format
    //All of these are arrays

    public Card() {
        String questions[] = {"In the 1990s, how many of TIME magazine's Man of the year covers featured two or more people",
                "How many mammals have thicker fur than sea otters?",
                "How many inches over five feet tall is Lady Gaga?",
                "How many raindrops are less than half a milometer in diameter?",
                "How many of these other countries border the Mediterranean Sea: Greece, Libya, Portugal?",
                "How many categories of menswear increased in price between 2013 and 2016?",
                "Of the six members of the quirky British comedy group Monty Python, how many were Americas?",
                "How many NBA b-ballers have played for both championship finals teams in the same season?",
                "How many ballet dancers are performing in a pas de deux?",
                "How many people have died from being hit by a penny from the Empire State Building?",
                "How many comic books have sold for more then $3 million at auction?",
                "FAA regulations require how many flight attendants for every 50 passengers on an aircraft",
                "How many colors coat the black licorice centers of Good & Plenty candies?",
                "How many of the U.S. state abbreviations feature two vowels?",
                "How many of the six noble gasses do not end in \"on\"?",
                "How many times has Canada hosted the Winter Olympics?",
                "How many U.S. national monuments have been dedicated to honor the LGBT community?",
                "How many of the 54 countries in Africa have a one-syllable name?",
                "How many of the episode titles on TV's Friends do not begin with these two words \"The One.\"",
                "How many teams did Packers legend Vinoe Lombardi coach after he left Green Bay in 1969?",
                "How many NFL teams have played the Super Bowl on their own home field",
                "How many words in the English language rhyme with the word silver?",
                "About how many months did it take Erno Rubik to solve his famous colourful cube for the first time",
                "The traditional game of Magic: The Gathering, how many lands does each player start with on the table?",
                "How many characters in the Harry Potter series are able to survive the powerful killing curse?",
                "How many species of birds can outrun an ostrich?",
                "Of the four blood types, how many can donate to the exact same blood type group",
                "How many South American countries have hosted the Summer Olympic Games?",
                "How many earth worms are formed when you divide one in half?",
                "As of 2015, how many countries are more charitable than the United States",
                "How many eggs does a bat lay in each brood?",
                "How many albums by Miles Davis are in the list of top 10 best-selling jazz albums of all time",
                "In the nursery rhyme, how many bones were in Old Mother Hubbard's cupboard?",
                "How many paintings did Vincent van Gogh sell during his lifetime?",
                "How many properties in the traditional game of Monopoly are not named after places in Atlantic City, New Jersey?",
                "How many of the four ghosts in Pac-Man have names that do not rhyme with the other",
                "How many continents cover all four hemispheres: North, South, East, and West",
                "How many Major League Baseball pitchers have hit a grand slam in a World Series",
                "How many native U.S. lizards are larger than the Gila Monster",
                "For how many Westerns was director John Ford awarded an Oscar?",
                "How many members of the rock band US have been replaced since their 1978 formation",
                "What is the letter value of a blank tile in a Scrabble game?",
                "In the Olympic five-ring logo, how many rings does the red one touch",
                "How many dollars did an adult pay for an all-day ticket on to Disneyland's opening day in 1955?",
                "Besides chocolate, how many flavours were included in the original 3 Musketeers candy bar?",
                "How many U.S. capitals do not have a McDonald's?",
                "How many times was Adolf Hitler nominated for the Nobel Peace Prize?",
                "How many grand slams have been hit during an MLB All-Star game?",
                "In tennis, if the score is deuce, how many consecutive points do you need to win the game?",
                "What percentage of the fines collected by NASCAR per year is not donated to charity?",
                "How many of Newtons 3 laws of motion state heavier objects require more force to move?",
                "What numbers is shown on the green a lot of a roulette wheel?",
                "How many Nobel Prizes are awarded in Norway?",
                "How many baby birds are chirping in the nest of the Nestle logo?",
                "How many black bear sightings have been reported in Indiana during the past 100 years?",
                "How many letters are blue in the eBay logo?",
                "How many zodiac symbols sport horns, other than Taurus the bull?",
                "How many of the actors in the original Star Trek TV series appeared in all 80 episodes, including the pilot",
                "How many planets in our solar System rotate sideways, rather than clockwise or counterclockwise?",
                "As of 2016, how many daytime soap operas were still airing on NBC",
                "How many of the 12 Apostles of Jesus Christ were not martyred?",
                "How many hits by the pop music sensation ABBA reached #1 on the U.S. Billboard charts?",
                "As of July 2016, how many search engines are more popular than Bing?",
                "How many passenger pigeons were alive on September 2, 1914?",
                "In the Star Wars prequels, which number episode is Attack of the Clones?",
                "How many fewer letters than the English alphabet does the Greek alphabet have?",
                "How many U.S. states have given their name to elements on the periodic table?",
                "How many times have U.S astronauts walked on the moon during the last 40 years?",
                "How many insect bites are more painful than that of the bullet ant?",
                "How many animals are on the Australian coat of arms?",
                "How many Marvel heroes and villains survived the 1956 comic book, 'Punisher Kills the Marvel Universe'?",
                "How many of Canada's ten provinces are officially bilingual?",
                "How many siblings does Daniel Radcliffe have?",
                "In a standard deck on playing cards, how many of the jacks are pictured in profiles, not face-forward?",
                "According to the an Oxford Database, how many of the 10 most used words in English have four letters?",
                "In Harry Potter, how many of the four houses have a mammal as a crest animal?",
                "How many buttons does Micky Mouse have on his pants?"};

        int ans[] = {2, 0, 1, 0, 2, 1, 1, 1, 2, 0, 1, 1, 2, 1, 1, 2, 1, 1, 2,
                1, 0, 0, 1, 0, 2, 0, 1, 1, 1, 1, 0, 2, 0, 1, 1, 1, 1, 1, 1, 0,
                0, 0, 0, 1, 1, 2, 1, 1, 1, 2, 0, 0, 2, 0, 1, 2, 2, 1, 2, 1, 1,
                1, 1, 1, 1, 1, 0, 2, 2, 2, 0, 0, 2, 0, 1, 0, 2, 2, 2, 2};
        String reasons[] = {"In 1996, impeached POTUS Bill Clinton and his accuser Xen Starr; in 1993 it was peacemakers de Klerk, Mandela, Rabin, and Arafat.",
                "A sea otter can have as many as one million hairs per square inch on parts of its body",
                "Those 16-ich-high platforms shows just make her look taller",
                "The National Weather Service says size does matter; undersized raindrops are called drizzle, not drops.", "Only Greece and Libya share a Mediterranean shoreline. Portugal borders the atlantic",
                "In fact, underwear was the only clothing whose cost did not go down for guys during that period",
                "Only Perry Gillian. Brits are John Cleese, Michael Palin, Graham Chapman, Eric Idle, and Terry Jones",
                "Anderson Verejeo started the 2015-2016 season with the Cleveland Cavaliers, and ended it with the Golden State Warriors",
                "The phrases means \"steps for two.\" The Sugar Plus Fairy and her prince in the Nutcracker do a pas de deux, a tres bein one.",
                "TV's Mythbusters tested this our and proved that a penny dropped from that height cannot gain the necessary velocity",
                "The 1938 Action Comics #1 sold on eBay in 2014 for $3,207,852; it was the debut of Superman!",
                "That's also the average ratio of restrooms to passengers",
                "The pink and white candies, the oldest branded candy in the U.S. were first made in 1893.",
                "The only state is Iowa. its abbreviations are IA",
                "Neon Xenon, Argon, Krypton, and Radon all have the same two=letter ending. Helium is the exception",
                "Vancouver in 2010, and Calgary in 1955; Montreal hosted the Summer Olympics in 1976/",
                "The Stonewall National Monument in New York City, the site of a 1969 LGBT uprising, was designed by President Obama in 2016",
                "Chad is the only country",
                "The first episode is titles \"The Pilot\" and the final is called \"The Last One\"",
                "Lombardi led the Washington Redskins to their first winning record in 14 years",
                "In 50 Super Bowls as of 2016, no team has ever played the game at home.",
                "Its true! Along with month, purple, bulb, and orange, there are no words.",
                "And behold, this block then turned into a classic blockbuster game.",
                "During the game, players may play land from their hands in order to generate men for spells, creatures, and artifacts.",
                "Only Harry and Voldemort have the ability to escape the deadly spell's effects",
                "It is the fastest-running bird and the speediest two-legged animal in the world",
                "Type AB can donate to only other AB's, but can receive from all four blood types",
                "In 2016, Brazil's Summer Games were the first Olympic Games in the event''s 120-year history to be held in South America",
                "Only the front section survives (if it is lucky)",
                "Myanmar(formerly Burma) is more giving; Buddhism emphasizes charitable acts",
                "Bats are mammals, not birds, they give birth to live young. A female bat has one baby, or pup at a time",
                "Hia 1959 album 'Kind of Blue' placed #1, and his 'Bitches Brew' from 1970 is #9",
                "She went to the cupboard to get her dog a treat, but when she got there \"the cupboard was bare\"",
                "He sold Red Vineyard to his brother",
                "There's no Marvin Gardens in Atlantic City, although Marven Gardens (with and 'e') is located in nearby Margate City",
                "Clyde, the orange ghost is the only one; the other are named Inky, Blinky, and Pinky",
                "Africa, therefore, is also the only continent with land on both the prime meridian and the equator",
                "Dave McNally of the Baltimore Oriolas crushed it during game three of the 1970 series against Cincinnati",
                "The venomous lizard can grow up to two feet long, making it the biggest and baddest in America",
                "He won four Oscars, but none for Cowboy Fare",
                "All four members are still rockin'on",
                "There are only two in a game, and they can represent any letter.",
                "The red ring is in the first row on the far right and only touches the green ring.",
                "Kids got in for 50 cents", "The additional flavours include vanilla, chocolate, and strawberry",
                "Montpelier, Vermont, likes to keep things local. ",
                "In 1939, as a satiric gesture, an antifascist Swedish politician backed the Fuhrer, but later withdrew the nomination",
                "During the 50th anniversary game in 1963, Fred Lynn crushed it in the third inning, assuring a win for the American League",
                "\"Deuce\" is when each player has scored three points; the next point is called 'advantage' and the winning point is called 'game'",
                "All fine money goes into the NASCAR Foundation, which supports charitable causes",
                "His second and third law of motion use mass",
                "It's function is to tip the odds in the house's favor. American wheels have two green slots, giving casinos a bigger cut",
                "Only the Nobel Peace Prize is handed out in Norway; all others are awarded in Sweden.",
                "The Swiss company has momma bird in there too; a nice visual tie-in to their infant cereal items",
                "The first was spotted in 2015 in northern Indian; the second appeared in a drone video in 2016",
                "Only the 'B' is blue in the logo",
                "Aries the ram Capricorn the goat fit the description",
                "Leonard Nimoy, who played Spock, never missed a day of filming",
                "Uranus is titled on its side, causing its unique, lopsided spin",
                "Days of Our Lives is the only one",
                "John escaped unscathed from a boiling in-oil bath in Rome to later die in a natural death.",
                "Fourteen of their songs hit the Top 40, but only 'Dancing Queen' was #1",
                "Bing is a distant second to Google, which tops the list with a 70% market share.",
                "The last one, named Martha, died at the Cincinnati Zoo on September 1, 1914",
                "Part 1 is the Phantom Menace, and Part 3 is Revenge of the Sith",
                "The Greeks get it done with 24 letters",
                "California to Californium (Cf) and Tennessee to Tennessine (Ta)",
                "The last man-on-the-moon mission was Apollo 17 in 1972",
                "According to Schmidt's Sting Pain Index, the bullet ant is the most painful sting",
                "The kangaroo and emu. These animals cannot move backwards symbolizing a nation that always moves forward",
                "The Punisher wiped everyone out, including himself",
                "Only New Brunswick (English and French); Quebec is only French",
                "Just like Harry Potter, Daniel is an only child",
                "The so-called 'one-eyed jacks' are the Jack of Spades, and Jack of Hearts",
                "The word 'that' is #5 and 'have' is #9",
                "The lion and badger representing Gryffindor and Hufflepuff respectively",
                "There isn't really an explanation, its just always been like that"};

        //All of the above are arrays that hold the question, answer, and reason in order

        int rand = (int) (Math.random() * questions.length);
        question = questions[rand];
        answer = ans[rand];
        reason = reasons[rand];
        //The past 4 lines are the same as the donuts code, they generate a set of question, answer, and reason evertime a new card is constructed
    }

    public Card(String q, int a, String r) {
        //Constructors - holds the card answer, question, and reason
        question = q;
        answer = a;
        reason = r;

    }


    public String getQuestion() {
        //Accessors - access the question
        return question;

    }

    public void setQuestion(String q) {
        //Mutators - change the question
        question = q;
    }

    public int getAnswer() {
        //Accessors - access the answer
        return answer;
    }

    public void setAnswer(int a) {
        //Mutators - change the answer
        answer = a;
    }

    public String getReason() {
        //Accessors - get the reason
        return reason;
    }

    public void setReason(String r) {
        //Mutators - chagne the reason
        reason = r;
    }

    public boolean equals(Card r) {
        //Facilitator - see if 2 values are equal
        if (r.getQuestion().equalsIgnoreCase(question) && r.getAnswer() == answer && r.getReason().equalsIgnoreCase(reason)) {
            return true;
        } else
            return false;
    }

    public int compareTo(Card r) {
        //Facilitator - compare 2 cards
        if (r.getQuestion().compareTo(this.getQuestion()) < 0)
            return 1;
        else if (r.getQuestion().equals(this.getQuestion()))
            return 0;
        else
            return -1;
    }

    public String toString() {
        //Accessor - Convert all instance variables into a single string
        return "Question is " + question + ", answer is " + answer + ", reason is " + reason;
    }
}