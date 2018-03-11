import java.util.*;

public class EnglishPhonemic {
	
    private class Tuple {
        public String key;
        final List<String> examples = new ArrayList<String>();
        
        public Tuple(String... args) {
            this.key = args[0];
            for(int i = 1; i < args.length; i++) {
                this.examples.add(args[i]);
            }
        }
    }

    final Map<String, Tuple> vowels = new HashMap<String, Tuple>();
    final Map<String, Tuple> consonants = new HashMap<String, Tuple>();
    final List<String> miscconsonants = new ArrayList<String>();
        
    public EnglishPhonemic() {
        loadShortVowels();
        loadLongVowels();
        loadDiphthongVowels();
        loadFricativeConsonantsSounds();
        loadPlosiveConsonantsSounds();
        loadAffricateConsonantsSounds();
        loadNasalConsonantsSounds();
        loadApproximantsConsonantsSounds();
        loadOtherConsonantsSounds();
    }

    private void loadShortVowels() {
        vowels.put("ɛ", new Tuple("e", "went, intend, send"));
        vowels.put("e", new Tuple("e", "left, bed, let, read, let"));
        vowels.put("æ", new Tuple("a", "hat, fast, bath"));
        vowels.put("ʌ", new Tuple("u", "cup, luck, fun, love, money, one, London, come"));
        vowels.put("ʊ", new Tuple("oo", "book, put, should, cook, look"));
        vowels.put("ɑ", new Tuple("a", "far, rob, top, watch, squat, sausage, talk, jaw, law"));
        vowels.put("ə", new Tuple("er", "away, cinema, alive, again, teacher"));
        vowels.put("ɪ", new Tuple("i", "bit, ship, trip"));
    }

    private void loadLongVowels() {
        vowels.put("i", new Tuple("ee", "sheep, need, beat, read"));
        vowels.put("u", new Tuple("oo", "shoot, few, lose, fruit, chew"));
        vowels.put("ɜ", new Tuple("er", "nurse, heard, third, turn, her"));
        vowels.put("ɔ", new Tuple("oo", "door" ,"tour"));
        vowels.put("ɒ", new Tuple("o", "on"));
    }

    private void loadDiphthongVowels() {
        consonants.put("ɪə", new Tuple("ere", "ear", "near", "tear", "fear", "here"));
        consonants.put("eə", new Tuple("air", "hair", "tear", "pear", "care", "stairs", "there"));
        consonants.put("eɪ", new Tuple("ai", "wait"));
        consonants.put("ɔɪ", new Tuple("oi", "soar", "floor", "bore", "joy", "employ", "coil", "coin", "oyster"));
        consonants.put("aɪ", new Tuple("i", "my", "fly", "pride", "kind", "like"));
        consonants.put("ʊə", new Tuple("ou", "tour", "soar", "pure"));
        consonants.put("oʊ", new Tuple("ow", "no", "slow", "alone", "hole", "don't", "show"));
        consonants.put("aʊ", new Tuple("ou", "mouth", "sour", "house", "brown", "around", "out"));
        consonants.put("aʊ", new Tuple("ou", "mouth", "sour", "house", "brown", "around", "out"));
    }

    private void loadFricativeConsonantsSounds() {
        consonants.put("f", new Tuple("f", "free", "feel", "Friday", "knife", "phone"));
        consonants.put("v", new Tuple("v", "video", "vest", "cave", "give"));
        consonants.put("θ", new Tuple("th", "thought", "think", "bath"));
        consonants.put("ð", new Tuple("th", "this", "there", "those", "brother", "other"));
        consonants.put("z", new Tuple("z", "zoo", "crazy", "lazy", "zigzag", "nose", "Louisiana"));
        consonants.put("ʃ", new Tuple("sh", "shirt", "rush", "shop", "cash"));
        consonants.put("ʒ", new Tuple("s", "television", "delusion", "casual"));
        consonants.put("h", new Tuple("h", "high", "help", "hello"));
    }

    private void loadPlosiveConsonantsSounds() {
        consonants.put("s", new Tuple("s", "see", "sleep", "kiss", "seat", "Cedric"));
        consonants.put("p", new Tuple("p", "pea", "pin", "cap", "purpose", "pause"));
        consonants.put("b", new Tuple("b", "boat", "bag", "bubble", "build", "robe"));
        consonants.put("t", new Tuple("t", "tea", "time", "train", "tow", "late", "get"));
        consonants.put("d", new Tuple("d", "dog", "door", "day", "drive", "down", "feed"));
        consonants.put("k", new Tuple("k", "kite", "cash", "back", "quick", "cricket", "sock"));
        consonants.put("g", new Tuple("g", "go", "girl", "green", "grass", "flag", "exit"));
    }

    private void loadAffricateConsonantsSounds() {
        consonants.put("tʃ", new Tuple("ch", "choose", "cheese", "church", "watch"));
        consonants.put("ʤ", new Tuple("j", "joke", "juggle", "juice", "stage"));
    }

    private void loadNasalConsonantsSounds() {
        consonants.put("m", new Tuple("m", "mouse", "room", "mother", "mad", "more"));
        consonants.put("n", new Tuple("n", "now", "nobody", "knew", "turn"));
        consonants.put("ŋ", new Tuple("n", "thing", "king", "thing", "song", "swimming"));
    }

    private void loadApproximantsConsonantsSounds() {
        consonants.put("w", new Tuple("w", "we", "wall", "walk", "wine", "world", "window"));
        consonants.put("l", new Tuple("l", "love", "law", "lots", "leap", "long", "pill", "cold", "chill", "melt"));
        consonants.put("r", new Tuple("r", "run", "road", "roses", "river", "ring", "ride", "try"));
        consonants.put("j", new Tuple("y", "you", "yellow", "usual", "tune", "yesterday", "yard"));
    }

    private void loadOtherConsonantsSounds() {
        consonants.put("gz", new Tuple("x", "exact", "exam", "exit"));
        consonants.put("ks", new Tuple("x", "extreme", "expect", "next"));
    }

	public String execute(final String input) {
        final String output = input;
        return output;
    }  

    public static void main(String[] args) {
        final String input = args.length == 1 ? args[0] : "Louisiana";
		EnglishPhonemic instance = new EnglishPhonemic(); 
		final String output = instance.execute(input);
        System.out.println("Output:" + output);
    }
}