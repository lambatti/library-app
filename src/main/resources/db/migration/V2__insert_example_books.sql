WITH books_json (doc) AS (
    VALUES ('[
      {
        "id": 1,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4942000/4942534/930750-352x500.jpg",
        "title": "Diuna",
        "author": "Frank Herbert",
        "publication_date": "2021-10-12",
        "genre": "fantasy, science fiction",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Arrakis, zwana Diuną, to jedyne we wszechświecie źródło melanżu. Z rozkazu Padyszacha Imperatora planetę przejmują Atrydzi, zaciekli wrogowie władających nią dotychczas Harkonnenów. Zwycięstwo księcia Leto Atrydy jest jednak pozorne – przejęcie planety ukartowano. W odpowiedzi na atak Imperium i Harkonnenów dziedzic rodu Atrydów Paul staje na czele rdzennych mieszkańców Diuny i sięga po imperialny tron. Oszałamiające połączenie przygody oraz mistycyzmu, ekologii i polityki."
      },
      {
        "id": 2,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4987000/4987994/934953-352x500.jpg",
        "title": "Zaraza",
        "author": "Przemysław Piotrowski",
        "publication_date": "2021-11-10",
        "genre": "kryminał, sensacja, thriller",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Po tym, jak cudem uszedł z życiem z zasadzki psychopatycznego mordercy, Igor Brudny powoli i z trudem dochodzi do siebie. Świat, w którym się obudził, nie jest już jednak taki sam. Komisarz musi trzymać się z dala od Warszawy, a zielonogórski zespół inspektora Romualda Czarneckiego już nie istnieje. Ale przynajmniej dawna partnerka Brudnego, Julia Zawadzka, wciąż jest przy nim."
      },
      {
        "id": 3,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4988000/4988766/936150-352x500.jpg",
        "title": "Przepaść",
        "author": "Remigiusz Mróz",
        "publication_date": "2021-10-27",
        "genre": "kryminał, sensacja, thriller",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "W Tatrach Zachodnich dochodzi do zaginięcia młodej kobiety z Warszawy. Ostatnim razem widziana była przez turystów w okolicy Trzydniowiańskiego Wierchu, a potem przepadła bez wieści. Był to jej pierwszy wyjazd w góry, miała zamiar spędzić w nich tylko weekend, a w Zakopanem pojawiła się sama – mimo to wedle ustaleń policji szła czerwonym szlakiem w towarzystwie czterech mężczyzn. Sprawę prowadzi Wiktor Forst, który odtwarza trasę dziewczyny z nadzieją, że odnajdzie ją żywą."
      },
      {
        "id": 4,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4963000/4963872/943821-352x500.jpg",
        "title": "Start a fire. Runda pierwsza",
        "author": "P.S. Herytiera",
        "publication_date": "2022-01-12",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Victoria Joseline Clark nigdy nie należała do szczególnie rozważnych dziewczyn, choć nie można jej było zarzucić braku inteligencji. Przez siedemnaście lat swojego życia uważała się za osobę przeciętną i taką również prowadziła egzystencję. Nauka w renomowanym liceum, wieczne kłótnie z irytującym bratem bliźniakiem, częste imprezy z przyjaciółmi, rodzinne kolacje w towarzystwie troskliwej matki i wiernego psa."
      },
      {
        "id": 5,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/308000/308630/494238-352x500.jpg",
        "title": "Harry Potter i Kamień Filozoficzny",
        "author": "J.K. Rowling",
        "publication_date": "2016-07-20",
        "genre": "literatura młodzieżowa",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Harry Potter, sierota i podrzutek, od niemowlęcia wychowywany był przez ciotkę i wuja, którzy traktowali go jak piąte koło u wozu. Pochodzenie chłopca owiane jest tajemnicą; jedyną pamiątką Harry`ego z przeszłości jest zagadkowa blizna na czole. Skąd jednak biorą się niesamowite zjawiska, które towarzyszą nieświadomemu niczego Potterowi? Wszystko zmienia się w dniu jedenastych urodzin chłopca, kiedy dowiaduje się o istnieniu świata, o którym nie miał dotąd pojęcia."
      },
      {
        "id": 6,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/308000/308636/532903-352x500.jpg",
        "title": "Harry Potter i Komnata Tajemnic",
        "author": "J.K. Rowling",
        "publication_date": "2016-07-20",
        "genre": "literatura młodzieżowa",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Harry po pełnym przygód roku w Hogwarcie spędza nudne wakacje u Dursleyów i z utęsknieniem wyczekuje powrotu do szkoły. Sprawy jednak znacznie się komplikują, gdy pewnego dnia odwiedza go tajemniczy przybysz i ostrzega przed… powrotem do Szkoły Magii i Czarodziejstwa, gdzie ma dojść do strasznych wydarzeń. Czy Harry posłucha ostrzeżenia? Co złego ma się wydarzyć w Hogwarcie? Jakie tajemnice skrywa rodzina Malforya? I najważniejsze – czym jest i gdzie znajduje się tytułowa Komnata Tajemnic?"
      },
      {
        "id": 7,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/308000/308637/532904-352x500.jpg",
        "title": "Harry Potter i więzień Azkabanu",
        "author": "J.K. Rowling",
        "publication_date": "2016-07-20",
        "genre": "literatura młodzieżowa",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Z pilnie strzeżonego więzienia dla czarodziejów ucieka niebezpieczny przestępca. Kim jest? Co go łączy z Harrym? Dlaczego lekcje przepowiadania przyszłości stają się dla bohatera udręką? W trzecim tomie przygód Harry`ego Pottera poznajemy nowego nauczyciela obrony przed czarną magią, oglądamy Hagrida w nowej roli oraz dowiadujemy się więcej o przeszłości profesora Snape`a."
      },
      {
        "id": 8,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4973000/4973956/911059-352x500.jpg",
        "title": "Mały Książę. Wydanie ekskluzywne",
        "author": "Antoine de Saint-Exupéry",
        "publication_date": "2020-10-12",
        "genre": "literatura piękna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Niezwykłe spotkanie w środku pustyni – pilot, który wraz ze swym samolotem spadł z nieba, mały przybysz z nieznanej planety i tajemniczy lis. Oto opowieść o dorastaniu do wiernej miłości, przyjaźni, lojalności i odpowiedzialności za drugiego człowieka."
      },
      {
        "id": 9,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4963000/4963224/890859-352x500.jpg",
        "title": "Mistrz i Małgorzata",
        "author": "Michaił Bułhakow",
        "publication_date": "2021-02-16",
        "genre": "klasyka",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Klasyka literatury w nowej edycji to znakomity pretekst, by powrócić do dzieł wybitnych i ważnych – przypomnieć je sobie, przeżyć i zinterpretować na nowo lub odkryć, czytając po raz pierwszy. Seria obejmuje arcydzieła polskiej i światowej literatury pięknej – utwory, które mimo upływu lat wciąż zachwycają, intrygują, wzruszają i skłaniają do refleksji."
      },
      {
        "id": 10,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4862000/4862898/690923-352x500.jpg",
        "title": "Igrzyska śmierci",
        "author": "Suzanne Collins",
        "publication_date": "2018-10-17",
        "genre": "literatura młodzieżowa",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Na ruinach dawnej Ameryki Północnej rozciąga się państwo Panem, z imponującym Kapitolem otoczonym przez dwanaście dystryktów. Okrutne władze stolicy zmuszają podległe sobie rejony do składania upiornej daniny. Raz w roku każdy dystrykt musi dostarczyć chłopca i dziewczynę między dwunastym a osiemnastym rokiem życia, by wzięli udział w Głodowych Igrzyskach, turnieju na śmierć i życie, transmitowanym na żywo przez telewizję."
      },
      {
        "id": 11,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/240000/240310/490965-352x500.jpg",
        "title": "Ostatnie życzenie",
        "author": "Andrzej Sapkowski",
        "publication_date": "2014-11-01",
        "genre": "fantasy, science fiction",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Później mówiono, że człowiek ów nadszedł od północy, od Bramy Powroźniczej. Nie był stary, ale włosy miał zupełnie białe. Kiedy ściągnął płaszcz, okazało się, że na pasie za plecami ma miecz.Białowłosego przywiodło do miasta królewskie orędzie: trzy tysiące orenów nagrody za odczarowanie nękającej mieszkańców Wyzimy strzygi."
      },
      {
        "id": 12,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4953000/4953463/869911-352x500.jpg",
        "title": "Oskar i pani Róża",
        "author": "Éric-Emmanuel Schmitt",
        "publication_date": "2021-01-20",
        "genre": "literatura piękna",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Oskar i pani Róża to najsłynniejsza powieść Érica-Emmanuela Schmitta, znakomitego francuskiego pisarza i filozofa, którego książki przetłumaczono na 35 języków. Czytelnicy na całym świecie pokochali go za niezrównaną wrażliwość i mądrość, z jaką opisuje nawet najbardziej skomplikowane emocje."
      },
      {
        "id": 13,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/3766000/3766803/865993-352x500.jpg",
        "title": "Dziewczyna z pociągu",
        "author": "Paula Hawkins",
        "publication_date": "2016-09-14",
        "genre": "kryminał, sensacja, thriller",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Rachel każdego ranka dojeżdża do pracy tym samym pociągiem. Wie, że pociąg zawsze zatrzymuje się przed tym samym semaforem, dokładnie naprzeciwko szeregu domów. Zaczyna się jej nawet wydawać, że zna ludzi, którzy mieszkają w jednym z nich. Uważa, że prowadzą doskonałe życie. Gdyby tylko mogła być tak szczęśliwa jak oni. I nagle widzi coś wstrząsającego. Widzi tylko przez chwilę, bo pociąg rusza, ale to wystarcza."
      },
      {
        "id": 14,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4804000/4804205/903512-352x500.jpg",
        "title": "Lalka",
        "author": "Bolesław Prus",
        "publication_date": "2017-01-01",
        "genre": "klasyka",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Stanisław Wokulski jest jedną z najbardziej fascynujących postaci w polskiej literaturze, a sama Lalka jest powieścią kochaną przez kolejne pokolenia. Nic dziwnego, ta uważana za najlepszą powieść Bolesława Prusa przedstawia prawdziwy świat, aktualne problemy i dylematy."
      },
      {
        "id": 15,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/10000/10416/365764-352x500.jpg",
        "title": "Kamienie na szaniec",
        "author": "Aleksander Kamiński",
        "publication_date": "2014-02-26",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Opowieść o Bohaterach Szarych Szeregów – Rudym, Alku, Zośce, zilustrowana ponad osiemdziesięcioma zdjęciami ze wszystkich epok Ich życia – od gniazda rodzinnego, poprzez czas harcerstwa, miłości, walki, po dni ostatnie!"
      },
      {
        "id": 16,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4929000/4929748/821323-352x500.jpg",
        "title": "Anioły i demony",
        "author": "Dan Brown",
        "publication_date": "2020-06-24",
        "genre": "kryminał, sensacja, thriller",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Robert Langdon zostaje pilnie wezwany do położonego koło Genewy centrum badań jądrowych CERN. Jego zadanie – zidentyfikować zagadkowy wzór wypalony na ciele zamordowanego fizyka. Langdon ze zdumieniem stwierdza, że jest to symbol tajemnego bractwa iluminatów – potężnej, aczkolwiek nieistniejącej od czterystu lat organizacji walczącej z Kościołem, do której należały najświetniejsze umysły Europy, chociażby Galileusz."
      },
      {
        "id": 17,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/35000/35932/901609-352x500.jpg",
        "title": "Alchemik",
        "author": "Paulo Coelho",
        "publication_date": "1995-01-01",
        "genre": "literatura piękna",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "„Alchemik” otwiera te drzwi w naszej duszy, o których istnieniu wolelibyśmy czasami zapomnieć. Każe marzyć, podążać za własnym powołaniem, podejmować ryzyko, pójść w świat i wrócić wystarczająco śmiałym, by stawić czoło wszelkim przeszkodom. Baśniowa, alegoryczna opowieść o wędrówce andaluzyjskiego pasterza jest tłem do medytacji nad tym, jak ominąć życiowe pułapki, by dotrzeć do samego siebie."
      },
      {
        "id": 18,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/225000/225665/289291-352x500.jpg",
        "title": "Gwiazd naszych wina",
        "author": "John Green",
        "publication_date": "2014-06-04",
        "genre": "literatura młodzieżowa",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Hazel choruje na raka i mimo cudownej terapii dającej perspektywę kilku lat więcej, wydaje się, że ostatni rozdział jej życia został spisany już podczas stawiania diagnozy. Lecz gdy na spotkaniu grupy wsparcia bohaterka powieści poznaje niezwykłego młodzieńca Augustusa Watersa, następuje nagły zwrot akcji i okazuje się, że jej historia być może zostanie napisana całkowicie na nowo."
      },
      {
        "id": 19,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4817000/4817417/617879-352x500.jpg",
        "title": "Dżuma",
        "author": "Albert Camus",
        "publication_date": "2017-06-12",
        "genre": "literatura piękna",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Metaforyczny obraz świata walczącego ze złem, którego symbolem jest tytułowa dżuma, pustosząca Oran w 194… roku. Wybuch epidemii wywołuje różne reakcje u mieszkańców, jednak stopniowo uznają słuszność postępowania doktora Rieux, który od początku aktywnie walczy z zarazą, uznając to za swój obowiązek jako człowieka i lekarza."
      },
      {
        "id": 20,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4944000/4944020/851652-352x500.jpg",
        "title": "Duma i uprzedzenie",
        "author": "Jane Austen",
        "publication_date": "2020-11-12",
        "genre": "klasyka",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Najgłośniejsza powieść Jane Austen, na podstawie której zrealizowano równie głośny film. Nawiązuje do niej Helen Fielding w bestsellerowym Dzienniku Bridget Jones. Niepozbawiona ironii i humoru kostiumowa opowieść o zamążpójściu."
      },
      {
        "id": 21,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4919000/4919644/798802-352x500.jpg",
        "title": "Cierpienia młodego Wertera",
        "author": "Johann Wolfgang von Goethe",
        "publication_date": "2016-01-01",
        "genre": "klasyka",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Powieść epistolarna napisana przez Johanna Wolfganga von Goethego, a opublikowana po raz pierwszy w 1774 r. \"Cierpienia młodego Wertera\", najważniejsze dzieło młodzieńcze J.W. Goethego, osnute na jego osobistych doświadczeniach, jest zapisem refleksji, doznań i wewnętrznych przeżyć bohatera."
      },
      {
        "id": 22,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4987000/4987700/934376-352x500.jpg",
        "title": "Wielki Gatsby",
        "author": "F. Scott Fitzgerald",
        "publication_date": "2021-10-13",
        "genre": "klasyka",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Powieść uznana za jedną z najważniejszych w XX wieku. Autor, Francis Scott Fitzgerald, czołowy twórca tzw. straconego pokolenia pisarzy amerykańskich, ukazał desperację i zagubienie młodych Amerykanów w okresie prosperity po I wojnie światowej. Właśnie barwny obraz obyczajów, romanse, miłości i tragedie oraz szybkie fortuny z prohibicją w tle stanowią o nieprzemijającym uroku książki."
      },
      {
        "id": 23,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4809000/4809795/603086-352x500.jpg",
        "title": "Norweski dziennik. Obce ścieżki",
        "author": "Andrzej Pilipiuk",
        "publication_date": "2017-11-10",
        "genre": "powieść przygodowa",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Paweł Koćko (lub jak kto woli Tomasz Paczenko) musi się ciągle ukrywać i nadal nie wie zbyt wiele o swojej tożsamości. Wciąż poszukuje odpowiedzi na pytania: kto podjął się pewnego szalonego eksperymentu genetycznego, jak rozumieć nawiedzające go niepokojące sny? I jakby tego jeszcze było mało, nie zawsze wiadomo, kto szpieg, a kto przyjaciel..."
      },
      {
        "id": 24,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4054000/4054030/532225-352x500.jpg",
        "title": "Był sobie pies",
        "author": "W. Bruce Cameron",
        "publication_date": "2017-02-15",
        "genre": "powieść przygodowa",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Bailey jest zszokowany – po krótkim i smętnym życiu, jakiego doświadczył w postaci bezpańskiego kundla, odradza się w ciele niesfornego szczeniaka. Kiedy trafia pod opiekę ośmiolatka Ethana, który kocha go całym sercem, odkrywa nowe oblicze – dobrego, poczciwego psiaka. Jednak życie u uwielbianej rodziny to nie koniec przygód Baileya. Ponownie odradza się w postaci kolejnego psa!"
      },
      {
        "id": 25,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/223000/223063/279447-352x500.jpg",
        "title": "Galop ’44",
        "author": "Monika Kowaleczko",
        "publication_date": "2014-07-30",
        "genre": "powieść przygodowa",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Mikołaj w przedziwny sposób trafia ze współczesnej Warszawy w sam wir dramatycznych wydarzeń powstania warszawskiego. Jego starszy brat Wojtek decyduje się na podróż, która zakończy się kilkadziesiąt lat wcześniej, aby wydostać Mikołaja z powrotem. W walczącej Warszawie chłopcy poznają na przemian smak zwycięstwa i gorycz porażki, dowiadują się, czym jest męstwo, prawdziwa przyjaźń i wielka miłość."
      },
      {
        "id": 26,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/238000/238009/329591-352x500.jpg",
        "title": "Grobowiec cesarza",
        "author": "Steve Berry",
        "publication_date": "2014-11-12",
        "genre": "powieść przygodowa",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Były agent specjalny amerykańskiego Departamentu Sprawiedliwości Cotton Malone, otrzymuje pewnego dnia anonimowy liścik z tajemniczym adresem internetowym. Po wejściu na wskazaną stronę widzi jak zamaskowany mężczyzna torturuje Kasjopeję Vitt, kobietę, która nie raz w przeszłości ocaliła jego skórę."
      },
      {
        "id": 27,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/293000/293510/466889-352x500.jpg",
        "title": "Ostatnia piosenka",
        "author": "Nicholas Sparks",
        "publication_date": "2016-01-07",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Zbuntowana siedemnastolatka, Ronnie, zostaje zmuszona do spędzenia wakacji w domu ojca, w odludnym nadmorskim miasteczku w Karolinie Północnej. To dla niej ciężka próba: nadal czuje żal do ojca po tym, ja trzy lata wcześniej opuścił rodzinę. Czy będą to najgorsze wakacje w życiu Ronnie? A może chłopak, którego pozna, odmieni jej życie na dobre...?"
      },
      {
        "id": 28,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/235000/235735/333448-352x500.jpg",
        "title": "Love, Rosie",
        "author": "Cecelia Ahern",
        "publication_date": "2014-12-03",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Rosie i Alex od dzieciństwa są nierozłączni. Życie zadaje im jednak okrutny cios: rodzice Alexa przenoszą się z Irlandii do Ameryki i chłopiec oczywiście jedzie tam razem z nimi. Czy magiczny związek dwojga młodych ludzi przetrwa lata i tysiące kilometrów rozłąki? Czy wielka przyjaźń przerodziłaby się w coś silniejszego, gdyby okoliczności ułożyły się inaczej? Jeżeli los da im jeszcze jedną szansę, czy Rosie i Alex znajdą w sobie dość odwagi, żeby spróbować się o tym przekonać?"
      },
      {
        "id": 29,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/3705000/3705027/504575-352x500.jpg",
        "title": "November 9",
        "author": "Colleen Hoover",
        "publication_date": "2016-11-09",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "9 listopada to data, która zaważyła na losach Fallon i Bena. Tego dnia spotkali się przypadkiem i od tej chwili zaczynają tworzyć dwie historie: jedna to ich życie, drugą pisze Ben zauroczony swoją nową muzą. Choć los postanawia ich rozdzielić, to wzajemna fascynacja jest na tyle silna, że nie może pokonać jej ani czas, ani odległość. "
      },
      {
        "id": 30,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4925000/4925994/818164-352x500.jpg",
        "title": "Współlokatorzy",
        "author": "Beth O''Leary",
        "publication_date": "2020-05-20",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Tiffy Moore pilnie potrzebuje taniego lokum. Leon Twomey bierze nocne zmiany, bo rozpaczliwie potrzebuje pieniędzy. Choć ich przyjaciele sądzą, że to szaleństwo, oni znajdują idealne rozwiązanie: w ciągu dnia Leon będzie w ciasnej kawalerce odsypiał noce zmiany, dzięki czemu Tiffy będzie miała to samo mieszkanie wyłącznie dla siebie przez resztę doby."
      },
      {
        "id": 31,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4899000/4899052/757670-352x500.jpg",
        "title": "Siedem sióstr",
        "author": "Lucinda Riley",
        "publication_date": "2019-11-13",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Sześć sióstr. Choć urodziły się na różnych kontynentach, wychowały się w bajecznej posiadłości Atlantis na prywatnym półwyspie Jeziora Genewskiego. Adopcyjny ojciec, nazywany przez nie Pa Saltem, nadał im imiona mitycznych Plejad. Każda ułożyła sobie życie po swojemu i rzadko mają okazję spotkać się wszystkie razem."
      },
      {
        "id": 32,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4862000/4862677/702540-352x500.jpg",
        "title": "Karuzela",
        "author": "Paulina Świst",
        "publication_date": "2018-11-14",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Dwoje młodych adwokatów, Piotr i Olka, przyjaźni się od studiów. Są uwikłani w kompletnie nieudane małżeństwa: mąż Oli jest hazardzistą z upodobaniem rozpuszczającym jej pieniądze, żona Piotra leczy się po załamaniu nerwowym."
      },
      {
        "id": 33,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4891000/4891326/742904-352x500.jpg",
        "title": "Bez przebaczenia",
        "author": "Agnieszka Lingas-Łoniewska",
        "publication_date": "2019-07-17",
        "genre": "literatura obyczajowa, romans",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Bez przebaczenia to opowieść o tym, jak drobne niedomówienia mogą się zmienić w mur obojętności i nienawiści, rzucający cień na całe życie. O tym, jak trudno się odsłonić ze strachu przed odrzuceniem i brakiem akceptacji. I wreszcie o tym, że jedyną siłą ratującą ten świat jest miłość."
      },
      {
        "id": 34,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4864000/4864254/693340-352x500.jpg",
        "title": "Metro 2033",
        "author": "Dmitry Glukhovsky",
        "publication_date": "2018-10-17",
        "genre": "fantasy, science fiction",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Czy kiedykolwiek przyszło ci do głowy, że ostatni epizod historii cywilizacji człowieka rozegra się w przejmującej atmosferze moskiewskiego metra? Czy człowiek, który w marzeniach sięgał gwiazd, godzien jest skończyć jak szczur, sto metrów pod ziemią? Mało prawdopodobne? Po przeczytaniu „Metra 2033” – rosyjskiego, kultowego już bestsellera, który zawładnął wyobraźnią ponad dwuipółmilionowej rzeszy czytelników – na pewno zmienisz zdanie."
      },
      {
        "id": 35,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4864000/4864256/693342-352x500.jpg",
        "title": "Metro 2034",
        "author": "Dmitry Glukhovsky",
        "publication_date": "2018-10-17",
        "genre": "fantasy, science fiction",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Moskwa 2034. Od pamiętnych wydarzeń, które początek i finał miały na stacji WOGN, minął niespełna rok. Na drugim krańcu moskiewskiego metra mieszkańcy Sewastopolskiej toczą walkę o przetrwanie z nowymi formami życia, wdzierającymi się z powierzchni do ostatniej ludzkiej enklawy. Los stacji i jej mieszkańców zależy od dostaw amunicji, a te nagle ustają. Karawany giną bez wieści, urywa się łączność."
      },
      {
        "id": 36,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/252000/252979/567433-352x500.jpg",
        "title": "Uczta dla wron: Cienie śmierci",
        "author": "George R.R. Martin",
        "publication_date": "2015-04-13",
        "genre": "fantasy, science fiction",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Po stuleciach ciągłych wojen i zdrad siedem osłabionych potęg dzielących władzę nad krainą zawarło ze sobą rozejm. Tak się przynajmniej wydaje. Po śmierci króla potwora, Joffreya, Cersei przejęła władzę w Królewskiej Przystani. Śmierć Robba Starka złamała kręgosłup buntowi północy, a rodzeństwo Młodego Wilka rozproszyło się po całym królestwie. "
      },
      {
        "id": 37,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4983000/4983288/928422-352x500.jpg",
        "title": "Malowany człowiek",
        "author": "Peter V. Brett",
        "publication_date": "2021-10-29",
        "genre": "fantasy, science fiction",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Z każdym zmierzchem, w oparach mgły, nadchodzą opętane żądzą mordu bestie. Przerażeni ludzie chronią się za magicznymi runami. Rzeź ustaje bladym świtem, gdy światło zapędza demony z powrotem w Otchłań."
      },
      {
        "id": 38,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/3868000/3868566/549689-352x500.jpg",
        "title": "Amerykańscy bogowie",
        "author": "Neil Gaiman",
        "publication_date": "2016-11-09",
        "genre": "fantasy, science fiction",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Po trzech latach spędzonych w więzieniu Cień ma wyjść na wolność. Ale w miarę jak do końca odsiadki pozostają tygodnie, godziny, minuty, sekundy, czuje narastający niepokój. Na dwa dni przed zakończeniem wyroku, jego żona, Laura, ginie wypadku samochodowym w tajemniczych okolicznościach – wszystko wskazuje na zdradę małżeńską."
      },
      {
        "id": 39,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4989000/4989803/937973-352x500.jpg",
        "title": "Ruiny Gorlanu",
        "author": "John Flanagan",
        "publication_date": "2021-11-10",
        "genre": "fantasy, science fiction",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Korpus Zwiadowców to najbardziej elitarna formacja w Królestwie Araluenu. Zwiadowcy, poza wypełnianiem misji wywiadowczej, są wyśmienitymi strategami i najlepszymi łucznikami. To im król ufa najbardziej i powierza im trudne zadania, w których muszą się wykazać nie tylko męstwem, niezłomnością i inteligencją, ale też lojalnością wobec władcy oraz dyskrecją. "
      },
      {
        "id": 40,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4845000/4845001/689585-352x500.jpg",
        "title": "Tatuażysta z Auschwitz",
        "author": "Heather Morris",
        "publication_date": "2018-04-18",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Lale Sokołow trafił do Auschwitz w 1942 roku jako dwudziestosześciolatek. Jego zadaniem było tatuowanie numerów na przedramionach przybywających do obozu więźniów. Naznaczanie ich. Pewnego dnia w kolejce stanęła młoda przerażona dziewczyna – Gita. Lale zakochał się od pierwszego wejrzenia. I obiecał sobie, że bez względu na wszystko uratuje ją."
      },
      {
        "id": 41,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4944000/4944147/851928-352x500.jpg",
        "title": "Król",
        "author": "Szczepan Twardoch",
        "publication_date": "2020-10-28",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Piękne samochody, kobiety, zimna wódka i gorąca krew. Boks, dzielnice nędzy i luksusowe burdele, błoto Woli i eleganckie ulice Śródmieścia. Żydzi i Polacy. Getto ławkowe i walki uliczne. Etniczny, społeczny, religijny i polityczny tygiel Warszawy 1937 roku. A pona"
      },
      {
        "id": 42,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/3788000/3788800/524364-352x500.jpg",
        "title": "Słowik",
        "author": "Kristin Hannah",
        "publication_date": "2016-10-12",
        "genre": "powieść historyczna",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Dwie siostry, Isabelle i Vianne, dzieli wszystko: wiek, okoliczności, w jakich przyszło im dorastać, i doświadczenia. Kiedy w 1940 roku do Francji wkracza armia niemiecka, każda z nich rozpoczyna własną niebezpieczną drogę do przetrwania, miłości i wolności."
      },
      {
        "id": 43,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4844000/4844304/654448-352x500.jpg",
        "title": "Rodzina Borgiów",
        "author": "Mario Puzo",
        "publication_date": "2018-05-28",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Intrygi rodziny, której nazwisko zawsze było synonimem władzy, korupcji i zbrodni – niesławnych Borgiów. Na tle barwnego zgiełku włoskiego renesansu rozgrywa się partia śmiertelnej gry, której stawką jest władza nad centrum świata – Rzymem."
      },
      {
        "id": 44,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4906000/4906496/774029-352x500.jpg",
        "title": "Podróż Cilki",
        "author": "Heather Morris",
        "publication_date": "2020-01-15",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Kontynuacja międzynarodowego bestsellera Tatuażysta z Auschwitz.Historia młodziutkiej dziewczyny, którą Lale Sokołow, tatuażysta z Auschwitz, uważał za najdzielniejszą osobę, jaką kiedykolwiek poznał.Uroda ją uratowała – i skazała na piekło. Cilka ma zaledwie szesnaście lat, kiedy trafia do Auschwitz. Tam szybko się uczy, że uroda daje siłę, a ta oznacza przetrwanie."
      },
      {
        "id": 45,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/162000/162463/352x500.jpg",
        "title": "Shogun",
        "author": "James Clavell",
        "publication_date": "2012-10-18",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Główny bohater rozgrywającej się na przełomie XVI i XVII wieku opowieści – angielski żeglarz John Blackthorne trafia do Japonii w przełomowym momencie jej historii- tuż po śmierci genialnego wodza i reformatora, który zjednoczył kraj Toyotomiego Hideyoshiego."
      },
      {
        "id": 46,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/260000/260708/592231-352x500.jpg",
        "title": "Złodziejka",
        "author": "Sarah Waters",
        "publication_date": "2015-08-04",
        "genre": "powieść historyczna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Wiktoriańska Anglia, 1862 rok. Susan Trinder i Maud Lilly mają po osiemnaście lat, obie są sierotami, obie straciły matki w dramatycznych okolicznościach. Sue Trinder, córka złodziejki i morderczyni, mieszka w Londynie przy Lant Street, w domu oszusta i pasera, gdzie codziennie załatwia się brudne interesy. "
      },
      {
        "id": 47,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/270000/270109/603561-352x500.jpg",
        "title": "Zabić drozda",
        "author": "Harper Lee",
        "publication_date": "2015-10-20",
        "genre": "literatura piękna",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Lata trzydzieste XX wieku, małe miasteczko na południu USA. Atticus Finch, adwokat i głowa rodziny, broni młodego Murzyna oskarżonego o zgwałcenie biednej białej dziewczyny Mayelli Ewell. Prosta sprawa sądowa z powodu wszechpanującego rasizmu, urasta do rangi symbolu. W codziennej walce o równouprawnienie czarnych jak echo powraca pytanie o to, gdzie przebiegają granice ludzkiej tolerancji."
      },
      {
        "id": 48,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4983000/4983356/927395-352x500.jpg",
        "title": "Pachnidło. Historia pewnego mordercy",
        "author": "Patrick Süskind",
        "publication_date": "2021-11-10",
        "genre": "literatura piękna",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "W slumsach osiemnastowiecznej Francji rodzi się Jean-Baptiste Grenouille. Ma wspaniały dar – węch absolutny. Zostaje zatrudniony u wybitnego paryskiego perfumiarza, który uczy go wykorzystywać ten dar do tworzenia unikatowych perfum. Nie jest to dla niego wystarczające. Chce za wszelką cenę uchwycić zapachy przedmiotów – mosiężnej klamki czy świeżo ściętego drzewa."
      },
      {
        "id": 49,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4931000/4931703/825699-352x500.jpg",
        "title": "Kod Leonarda da Vinci",
        "author": "Dan Brown",
        "publication_date": "2020-08-12",
        "genre": "kryminał, sensacja, thriller",
        "is_hardcover": true,
        "count": 1,
        "is_available": true,
        "description": "Jacques Saunière, kustosz Luwru, zostaje zamordowany. Francuska policja o pomoc w śledztwie zwraca się do Roberta Langdona, specjalisty od symboli. Okazuje się, że na miejscu zbrodni znajduje się wiele śladów, które mogą pomóc w ustaleniu zabójcy, ale też stanowią klucz do jeszcze większej zagadki − niezwykłej tajemnicy sięgającej korzeniami początków chrześcijaństwa."
      },
      {
        "id": 50,
        "cover_url": "https://s.lubimyczytac.pl/upload/books/4973000/4973920/910996-352x500.jpg",
        "title": "Ojciec chrzestny",
        "author": "Mario Puzo",
        "publication_date": "2021-06-30",
        "genre": "kryminał, sensacja, thriller",
        "is_hardcover": false,
        "count": 1,
        "is_available": true,
        "description": "Vito Corleone jest Ojcem Chrzestnym jednej z sześciu nowojorskich rodzin mafijnych. Sprawuje rządy żelazną ręką, a ci, którzy nie podporządkowują się jego decyzjom, nie mogą liczyć na łaskę. To człowiek honoru, ale zarazem tyran i szantażysta, który wśród wrogów wzbudza strach, a wśród przyjaciół – zasłużony, choć nie całkiem bezinteresowny, szacunek."
      }
    ]'::json))
INSERT
INTO books (id, cover_url, title, author, publication_date, genre, is_hardcover, count, is_available, description)
SELECT p.*
FROM books_json l
         CROSS JOIN lateral json_populate_recordset(NULL::books, doc) AS p
ON conflict (id) do update
    SET cover_url = excluded.cover_url,
        title      = excluded.title;

UPDATE books
SET genre = CASE
    WHEN genre = 'fantasy, science fiction' THEN 'FSF'
    WHEN genre = 'kryminał, sensacja, thriller' THEN 'KST'
    WHEN genre = 'literatura obyczajowa, romans' THEN 'LOR'
    WHEN genre = 'literatura młodzieżowa' THEN 'LM'
    WHEN genre = 'literatura piękna' THEN 'LP'
    WHEN genre = 'klasyka' THEN 'K'
    WHEN genre = 'powieść historyczna' THEN 'PH'
    WHEN genre = 'powieść przygodowa' THEN 'PP'
    ELSE ''
    END