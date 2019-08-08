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

    final Map<String, Tuple> vowelTranscriptionList = new HashMap<String, Tuple>();
    final Map<String, Tuple> consonantTranscriptionList = new HashMap<String, Tuple>();
    final List<String> miscconsonants = new ArrayList<String>();
        
    public EnglishPhonemic() {
        loadMonophthongVowelSounds();
        loadDiphthongVowels();
        loadFricativeConsonantsSounds();
        loadPlosiveConsonantsSounds();
        loadAffricateConsonantsSounds();
        loadNasalConsonantsSounds();
        loadApproximantsConsonantsSounds();
        loadOtherConsonantsSounds();
    }

    private void loadMonophthongVowelSounds() {
        loadShortVowels();
        loadLongVowels();
        loadDiphthongVowels();
    }

    private void loadShortVowels() {
        vowelTranscriptionList.put("ɛ", new Tuple("e", "went, intend, send"));
        vowelTranscriptionList.put("e", new Tuple("e", "left, bed, let, read, let"));
        vowelTranscriptionList.put("æ", new Tuple("a", "hat, fast, bath"));
        vowelTranscriptionList.put("ʌ", new Tuple("u", "cup, luck, fun, love, money, one, London, come"));
        vowelTranscriptionList.put("ʊ", new Tuple("oo", "book, put, should, cook, look"));
        vowelTranscriptionList.put("ɑ", new Tuple("a", "far, rob, top, watch, squat, sausage, talk, jaw, law"));
        vowelTranscriptionList.put("ə", new Tuple("er", "away, cinema, alive, again, teacher"));
        vowelTranscriptionList.put("ɪ", new Tuple("i", "bit, ship, trip"));
    }

    private void loadLongVowels() {
        vowelTranscriptionList.put("i", new Tuple("ee", "sheep, need, beat, read", "people"));
        vowelTranscriptionList.put("u", new Tuple("oo", "shoot, few, lose, fruit, chew", "glue", "beautiful"));
        vowelTranscriptionList.put("ɜ", new Tuple("er", "nurse, heard, third, turn, her"));
        vowelTranscriptionList.put("ɔ", new Tuple("oo", "door" ,"tour"));
        vowelTranscriptionList.put("ɒ", new Tuple("o", "on"));
    }

    private void loadDiphthongVowels() {
        consonantTranscriptionList.put("ɪə", new Tuple("ere", "ear", "near", "tear", "fear", "here"));
        consonantTranscriptionList.put("eə", new Tuple("air", "hair", "tear", "pear", "care", "stairs", "there"));
        consonantTranscriptionList.put("eɪ", new Tuple("ai", "wait", "gate", "stay"));
        consonantTranscriptionList.put("ɔɪ", new Tuple("oi", "soar", "floor", "bore", "joy", "employ", "coil", "coin", "oyster"));
        consonantTranscriptionList.put("aɪ", new Tuple("i", "my", "fly", "pride", "kind", "like", "guy", "die", "eye"));
        consonantTranscriptionList.put("ʊə", new Tuple("ou", "tour", "soar", "pure"));
        consonantTranscriptionList.put("oʊ", new Tuple("ow", "no", "slow", "alone", "hole", "don't", "show"));
        consonantTranscriptionList.put("aʊ", new Tuple("ou", "mouth", "sour", "house", "brown", "around", "out"));
        consonantTranscriptionList.put("aʊ", new Tuple("ou", "mouth", "sour", "house", "brown", "around", "out"));
    }

    private void loadDigraphConsonantSounds() {
        // sh, ch, th, wh, ck, ph, ng
    }

    private void loadDigraphVowelSounds() {
        //ai, ay, ee, ea, ie, ei, oo, ou. ow, oe, oo, ue, ey, ay, oy, oi, au, aw
    }

    private void loadMurmurDiphthongVowels() {
        /*
        ar
        er
        ir
        or
        ur
        */
    }

    private void loadFricativeConsonantsSounds() {
        consonantTranscriptionList.put("f", new Tuple("f", "free", "feel", "Friday", "knife", "phone"));
        consonantTranscriptionList.put("v", new Tuple("v", "video", "vest", "cave", "give"));
        consonantTranscriptionList.put("θ", new Tuple("th", "thought", "think", "bath"));
        consonantTranscriptionList.put("ð", new Tuple("th", "this", "there", "those", "brother", "other"));
        consonantTranscriptionList.put("z", new Tuple("z", "zoo", "crazy", "lazy", "zigzag", "nose", "Louisiana"));
        consonantTranscriptionList.put("ʃ", new Tuple("sh", "shirt", "rush", "shop", "cash"));
        consonantTranscriptionList.put("ʒ", new Tuple("s", "television", "delusion", "casual"));
        consonantTranscriptionList.put("h", new Tuple("h", "high", "help", "hello"));
    }

    private void loadPlosiveConsonantsSounds() {
        consonantTranscriptionList.put("s", new Tuple("s", "see", "sleep", "kiss", "seat", "Cedric"));
        consonantTranscriptionList.put("p", new Tuple("p", "pea", "pin", "cap", "purpose", "pause"));
        consonantTranscriptionList.put("b", new Tuple("b", "boat", "bag", "bubble", "build", "robe"));
        consonantTranscriptionList.put("t", new Tuple("t", "tea", "time", "train", "tow", "late", "get"));
        consonantTranscriptionList.put("d", new Tuple("d", "dog", "door", "day", "drive", "down", "feed"));
        consonantTranscriptionList.put("k", new Tuple("k", "kite", "cash", "back", "quick", "cricket", "sock"));
        consonantTranscriptionList.put("g", new Tuple("g", "go", "girl", "green", "grass", "flag", "exit"));
    }

    private void loadAffricateConsonantsSounds() {
        consonantTranscriptionList.put("tʃ", new Tuple("ch", "choose", "cheese", "church", "watch"));
        consonantTranscriptionList.put("ʤ", new Tuple("j", "joke", "juggle", "juice", "stage"));
    }

    private void loadNasalConsonantsSounds() {
        consonantTranscriptionList.put("m", new Tuple("m", "mouse", "room", "mother", "mad", "more"));
        consonantTranscriptionList.put("n", new Tuple("n", "now", "nobody", "knew", "turn"));
        consonantTranscriptionList.put("ŋ", new Tuple("n", "thing", "king", "thing", "song", "swimming"));
    }

    private void loadApproximantsConsonantsSounds() {
        consonantTranscriptionList.put("w", new Tuple("w", "we", "wall", "walk", "wine", "world", "window"));
        consonantTranscriptionList.put("l", new Tuple("l", "love", "law", "lots", "leap", "long", "pill", "cold", "chill", "melt"));
        consonantTranscriptionList.put("r", new Tuple("r", "run", "road", "roses", "river", "ring", "ride", "try"));
        consonantTranscriptionList.put("j", new Tuple("y", "you", "yellow", "usual", "tune", "yesterday", "yard"));
    }

    private void loadOtherConsonantsSounds() {
        consonantTranscriptionList.put("gz", new Tuple("x", "exact", "exam", "exit"));
        consonantTranscriptionList.put("ks", new Tuple("x", "extreme", "expect", "next"));
    }

	public String execute(final String input) {
        final String output = input;
        return output;
    }  

    private void primaryStress() {
     //IPA #: 501
     //Entity: &#712;
     //Unicode: U+02C8   
    }

    private void primaryStress() {
     //IPA #: 502
     //Entity: &#716;
     //Unicode: U+02CC   
    }

    private void stressFirstSyllable() {
        //Nouns, adjectives, words ending in er, ly, and consonant+y stress the first syllable
    }

    private void stressSecondSyllable() {
        //Most verbs and prepositions stress the first syllable
    }

    //some words can be pronounced in two different ways
    //e.g. PREsent and preSENT; OBject and obJECT.

    public static void main(String[] args) {
        final String input = args.length == 1 ? args[0] : "Louisiana";
		EnglishPhonemic instance = new EnglishPhonemic(); 
		final String output = instance.execute(input);
        System.out.println("Output:" + output);
    }
}
