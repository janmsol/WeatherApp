package com.example.janms.oblig2;

import android.content.SearchRecentSuggestionsProvider;

public class SearchSuggestion extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.example.janms.oblig2.SearchSuggestion";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchSuggestion() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
