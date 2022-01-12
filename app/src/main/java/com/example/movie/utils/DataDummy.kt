package com.example.movie.utils

import com.example.movie.data.source.local.entity.Entity
import com.example.movie.data.source.remote.response.MovieResponse
import com.example.movie.data.source.remote.response.ShowResponse

object DataDummy {
    fun generateDummyMovies() : List<Entity> {
        val movies = ArrayList<Entity>()

        movies.add(
            Entity(
            "movie",
            "Creed II",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "130 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
            "https://www.themoviedb.org/t/p/original/9il7qNbeYnPMYlutsVYDsj4hRyb.jpg"
        )
        )
        movies.add(
            Entity(
            "movie",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "143 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "https://www.themoviedb.org/t/p/original/q0Xd7Sb5aKauOv0H4JyKOICGktN.jpg"

        )
        )
        movies.add(
            Entity(
            "movie",
            "Alita: Battle Angle",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "122 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "https://www.themoviedb.org/t/p/original/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
        )
        )
        movies.add(
            Entity(
            "movie",
            "Avengers: Infinity War",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "149 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "https://www.themoviedb.org/t/p/original/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg"
        )
        )
        movies.add(
            Entity(
            "movie",
            "How to Train Your Dragon",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father.",
            "98 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/q9JwFktEfzdXlE7gFjKSTOD3jpK.jpg",
            "https://www.themoviedb.org/t/p/original/aH9KWmXFMamXkHMgLjnQmSYjScL.jpg"
        )
        )

        return movies
    }
    fun generateDummyShows() : List<Entity> {
        val shows = ArrayList<Entity>()

        shows.add(
            Entity(
                "show",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "42 minutes",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://www.themoviedb.org/t/p/original/vNnLAKmoczRlNarxyGrrw0KSOeX.jpg"
        )
        )
        shows.add(
            Entity(
                "show",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "42 minutes",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "https://www.themoviedb.org/t/p/original/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg"
        )
        )
        shows.add(
            Entity(
                "show",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "43 minutes",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "https://www.themoviedb.org/t/p/original/7QSM3AsgWXctWBm7OFov9dGdZgt.jpg"
        )
        )
        shows.add(
            Entity(
                "show",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "22 minutes",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                "https://www.themoviedb.org/t/p/original/evOGWG3fqgjIpsAKJaVF7d6of1K.jpg"
        )
        )
        shows.add(
            Entity(
                "show",
                "Naruto Shipudden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "25 minutes",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                "https://www.themoviedb.org/t/p/original/8OXCF1vdFjU5hRs92uH1x9boUi9.jpg"
        )
        )

        return shows
    }


    fun generateRemoteDummyMovies() : List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(
            "movie",
            "Creed II",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "130 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
            "https://www.themoviedb.org/t/p/original/9il7qNbeYnPMYlutsVYDsj4hRyb.jpg"
        ))
        movies.add(MovieResponse(
            "movie",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "143 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "https://www.themoviedb.org/t/p/original/q0Xd7Sb5aKauOv0H4JyKOICGktN.jpg"

        ))
        movies.add(MovieResponse(
            "movie",
            "Alita: Battle Angle",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "122 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "https://www.themoviedb.org/t/p/original/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
        ))
        movies.add(MovieResponse(
            "movie",
            "Avengers: Infinity War",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "149 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "https://www.themoviedb.org/t/p/original/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg"
        ))
        movies.add(MovieResponse(
            "movie",
            "How to Train Your Dragon",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father.",
            "98 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/q9JwFktEfzdXlE7gFjKSTOD3jpK.jpg",
            "https://www.themoviedb.org/t/p/original/aH9KWmXFMamXkHMgLjnQmSYjScL.jpg"
        ))

        return movies
    }
    fun generateRemoteDummyShows() : List<ShowResponse> {
        val shows = ArrayList<ShowResponse>()

        shows.add(
            ShowResponse(
            "show",
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "42 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            "https://www.themoviedb.org/t/p/original/vNnLAKmoczRlNarxyGrrw0KSOeX.jpg"
        )
        )
        shows.add(ShowResponse(
            "show",
            "The Walking Dead",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "42 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            "https://www.themoviedb.org/t/p/original/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg"
        ))
        shows.add(ShowResponse(
            "show",
            "Gotham",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "43 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            "https://www.themoviedb.org/t/p/original/7QSM3AsgWXctWBm7OFov9dGdZgt.jpg"
        ))
        shows.add(ShowResponse(
            "show",
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "22 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
            "https://www.themoviedb.org/t/p/original/evOGWG3fqgjIpsAKJaVF7d6of1K.jpg"
        ))
        shows.add(ShowResponse(
            "show",
            "Naruto Shipudden",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "25 minutes",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
            "https://www.themoviedb.org/t/p/original/8OXCF1vdFjU5hRs92uH1x9boUi9.jpg"
        ))

        return shows
    }

//    fun dummyMovieId() : ArrayList<String> {
//        val list = ArrayList<String>()
//        list.add("480530")
//        list.add("297802")
//        list.add("399579")
//        list.add("299536")
//        list.add("10191")
//
//        return list
//    }
//
//    fun dummyShowId() : ArrayList<String> {
//        val list = ArrayList<String>()
//        list.add("1412")
//        list.add("1402")
//        list.add("60708")
//        list.add("456")
//        list.add("31910")
//
//        return list
//    }

}