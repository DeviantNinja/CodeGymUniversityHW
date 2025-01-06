package Lesson17XmasHW;


public class Main {
    public static void main(String[] args) {

        String testText = "In the bustling town of Marketville, 5 merchants set up their stalls @ the weekly market. " +
                "The aroma of freshly baked bread, priced @ £2.50 per loaf, filled the air. Children gleefully co#unted " +
                "their pennies - 10 in total - to buy s$weets. A musician played lively tunes, while a painter sold his " +
                "artw$ork for $15 each. The mayor announced, “J%oin us @ 7 PM for a grand fireworks display!” With stars " +
                "twinkling above, families ga&thered, their hearts $filled$ with joy. It was a day of simple pleasures, " +
                "where every1 found a r#eason to smile. Life in Marketville was indeed special!&&*#";
        WordSuggestion suggestion = new WordSuggestion(testText);
        System.out.println(suggestion);
        System.out.println(suggestion.mostUsedWords("grand",10));


    }
}
