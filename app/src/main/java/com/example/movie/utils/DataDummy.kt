package com.example.movie.utils

import com.example.movie.R
import com.example.movie.data.Entity

object DataDummy {
    fun generateDummyMovies() : List<Entity> {
        val movies = ArrayList<Entity>()

        movies.add(Entity(
            "a14",
            "Creed II",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "2h 10m",
            R.drawable.poster_creed,
            R.drawable.backdrop_creed
        ))
        movies.add(Entity(
            "a55",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "2h 23m",
            R.drawable.poster_aquaman,
            R.drawable.backdrop_aquaman

        ))
        movies.add(Entity(
            "a47",
            "Alita: Battle Angle",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "2h 2m",
            R.drawable.poster_alita,
            R.drawable.backdrop_alita
        ))
        movies.add(Entity(
            "a74",
            "Avengers: Infinity War",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "2h 29m",
            R.drawable.poster_infinity_war,
            R.drawable.backdrop_infinity
        ))
        movies.add(Entity(
            "a51",
            "How to Train Your Dragon",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father.",
            "1h 38m",
            R.drawable.poster_how_to_train,
            R.drawable.backdrop_how_to
        ))

        return movies
    }
    fun generateDummyShows() : List<Entity> {
        val shows = ArrayList<Entity>()

        shows.add(Entity(
                "b14",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "42m",
                R.drawable.poster_arrow,
                R.drawable.backdrop_arrow
        ))
        shows.add(Entity(
                "b55",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "42m",
                R.drawable.poster_the_walking_dead,
                R.drawable.backdrop_walking_dead
        ))
        shows.add(Entity(
                "b47",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "43m",
                R.drawable.poster_gotham,
                R.drawable.backdrop_gotham
        ))
        shows.add(Entity(
                "b74",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "22m",
                R.drawable.poster_the_simpson,
                R.drawable.backdrop_simpson
        ))
        shows.add(Entity(
                "b51",
                "Naruto Shipudden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "25m",
                R.drawable.poster_naruto_shipudden,
                R.drawable.backdrop_naruto
        ))

        return shows
    }

}