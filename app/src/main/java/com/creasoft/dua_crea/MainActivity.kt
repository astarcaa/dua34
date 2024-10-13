package com.creasoft.dua_crea

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {

    private lateinit var duaList: List<Dua>
    private lateinit var rvDuaList: RecyclerView

    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdView = findViewById(R.id.adView)


        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        rvDuaList = findViewById(R.id.rv_dua_list)

        // Dua listesini hazırlayın
        duaList = listOf(
            Dua(
                "Sübhaneke",
                "سُبْحَانَكَ اَللّٰهُمَّ وَبِحَمْدِكَ وَتَبَارَكَ اسْمُكَ وَتَعَالٰى جَدُّكَ (وَجَلَّ ثَنَآئُكَ) وَلاَ اِلٰهَ غَيْرُكَ\n" +
                        "\n...",
                "Subhânekellâhumme ve bi hamdik ve tebârekesmuk ve teâlâ cedduk (ve celle senâuk *) ve lâ ilâhe ğayruk.\n\n",
                "Allah'ım! Sen eksik sıfatlardan pak ve uzaksın. Seni daima böyle tenzih eder ve överim. Senin adın mübarektir. Varlığın her şeyden üstündür. Senden başka ilah yoktur.\n" +
                        "\n" +
                        "* Sübhâneke duası, sadece Cenaze namazında parantez içindeki “Ve celle senâük” cümlesi ile beraber okunur."
            ),
            Dua(
                "Ettehiyyatü",
                "التَّحِيَّاتُ لِلَّهِ وَالصَّلَوَاتُ وَالطَّيِّبَاتُ ﴿﴾السَّلامُ عَلَيْكَ أَيُّهَا النَّبِيُّ وَرَحْمَةُ اللَّهِ وَبَرَكَاتُهُ ﴿﴾ السَّلامُ عَلَيْنَا وَعَلَى عِبَادِ اللَّهِ الصَّالِحِينَ ﴿﴾ أَشْهَدُ أَنْ لا إِلَهَ إِلا اللَّهُ ﴿﴾ وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُولُهُ\n" +
                        "\n",
                "Ettehiyyâtu lillâhi ve’s-salevâtu ve’t-tayyibâtu esselâmu ‘aleyke eyyuhe’n-nebiyyu ve rahmetullâhi ve berakâtuhû esselâmu ‘aleynâ ve ‘alâ ‘ıbâdillâhi’s-salihîn. Eşhedu en lâ ilâhe illallâh ve eşhedu enne Muhammeden ‘abduhû ve rasûluh.\n\n",
                "Selam, rahmet ve bütün güzellikler, her türlü dil, beden ve mal ile yapılan ibadet Allah’a mahsustur. Ey Peygamber! Allah’ın rahmeti ve bereketleri senin üzerine olsun. Selâm bizlere ve Allah’ın sâlih kullarına olsun. Ben şehadet ederim (kesinlikle bilirim) ki, Allah’tan başka hiçbir ilâh yoktur. Ve şehadet ederim ki Hazret-i Muhammed Allah’ın kulu ve Resûlüdür."
            ),


            // Diğer dualar bu şekilde eklenebilir
            Dua(
                "Rabbenâ Atina",
                "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً...",
                "Rabbena atina fid-dünya...",
                "Ey Rabbimiz! Bize dünyada iyilik ver..."
            ),
            Dua(
                "Âyet-el Kürsi",
                "\n" +
                        "اَللّٰهُ لَٓا اِلٰهَ اِلَّا هُوَۚ اَلْحَيُّ الْقَيُّومُۚ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌؕ لَهُ مَا فِي السَّمٰوَاتِ وَمَا فِي الْاَرْضِؕ مَنْ ذَا الَّذٖي يَشْفَعُ عِنْدَهُٓ اِلَّا بِاِذْنِهٖؕ يَعْلَمُ مَا بَيْنَ اَيْدٖيهِمْ وَمَا خَلْفَهُمْۚ وَلَا يُحٖيطُونَ بِشَيْءٍ مِنْ عِلْمِهٖٓ اِلَّا بِمَا شَٓاءَۚ وَسِعَ كُرْسِيُّهُ السَّمٰوَاتِ وَالْاَرْضَۚ وَلَا يَؤُ۫دُهُ حِفْظُهُمَاۚ وَهُوَ الْعَلِيُّ الْعَظٖيمُ\n\n",
                "Allâhu lâ ilâhe illâ huve’l-hayyu’l-kayyûm. Lâ te’huzuhû sinetun ve lâ nevm. Lehû mâ fi’s-semâvâti ve mâ fi’l-ardı men zellezî yeşfe’u ‘ındehû illâ bi iznih. Ya’lemu mâ beyne eydîhim ve mâ halfehum ve lâ yuhîtûne bi şey’in min ‘ılmihî illâ bimâ şâe vesi’a kursiyyuhu’s-semâvâti ve’larda ve lâ yeûduhû hıfzuhumâ ve huve’l-‘aliyyu’l-‘azîm.\n\n",
                "Allah, kendisinden başka hiçbir ilâh olmayandır. Diridir, kayyumdur. O’nu ne bir uyuklama tutabilir, ne de bir uyku. Göklerdeki her şey, yerdeki her şey O’nundur. İzni olmaksızın O’nun katında şefaatte bulunacak kimdir? O, kulların önlerindekileri ve arkalarındakileri (yaptıklarını ve yapacaklarını) bilir. Onlar O’nun ilminden, kendisinin dilediği kadarından başka bir şey kavrayamazlar. O’nun kürsüsü, bütün gökleri ve yeri kaplayıp kuşatmıştır. (O, göklere, yere, bütün evrene hükmetmektedir.) Gökleri ve yeri koruyup gözetmek O’na güç gelmez. O, yücedir, büyüktür.Allah, kendisinden başka hiçbir ilâh olmayandır. Diridir, kayyumdur. O’nu ne bir uyuklama tutabilir, ne de bir uyku. Göklerdeki her şey, yerdeki her şey O’nundur. İzni olmaksızın O’nun katında şefaatte bulunacak kimdir? O, kulların önlerindekileri ve arkalarındakileri (yaptıklarını ve yapacaklarını) bilir. Onlar O’nun ilminden, kendisinin dilediği kadarından başka bir şey kavrayamazlar. O’nun kürsüsü, bütün gökleri ve yeri kaplayıp kuşatmıştır. (O, göklere, yere, bütün evrene hükmetmektedir.) Gökleri ve yeri koruyup gözetmek O’na güç gelmez. O, yücedir, büyüktür."

            ),
            Dua(
                "Fatiha Suresi",
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيمِ ﴿١﴾ الْحَمْدُ لِلّٰهِ رَبِّ الْعَالَمِينَ ﴿٢﴾ الرَّحْمٰنِ الرَّحِيمِ ﴿٣﴾ مٰلِكِ يَوْمِ الدِّينِ ﴿٤﴾ إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ ﴿٥﴾ اهْدِنَا الصِّرَاطَ الْمُسْتَقِيمَ ﴿٦﴾ صِرَاطَ الَّذِينَ أَنْعَمْتَ عَلَيْهِمْ غَيْرِ الْمَغْضُوبِ عَلَيْهِمْ وَلَا الضَّلِّينَ ﴿٧﴾\n" +
                        "\n",
                "Bismillâhirrahmânirrahîm. Elhamdü lillâhi rabbil âlemîn. Errahmânirrahîm. Mâliki yevmiddîn. İyyâke na'budu ve iyyâke nesteîn. İhdinessırâtal mustakîm. Sırâtallezîne en'amte aleyhim ğayril mağdûbi aleyhim ve leddâllîn.\n\n",
                "Rahmân ve Rahîm olan Allah’ın adıyla. Hamd, âlemlerin Rabbi, Rahmân ve Rahîm, hesap gününün maliki olan Allah’a mahsustur. (Allahım!) Yalnız Sana ibadet ederiz ve yalnız Senden yardım dileriz. Bizi doğru yola ilet. Kendilerine nimet verdiklerinin yoluna, gazaba uğrayanların ve sapmışların yoluna değil."
            )
        )

        // Adapter ve RecyclerView'i ayarlayın
        val adapter = DuaAdapter(duaList) { selectedDua ->
            val intent = Intent(this, DuaDetailActivity::class.java)
            intent.putExtra("dua", selectedDua)
            startActivity(intent)
        }

        rvDuaList.layoutManager = LinearLayoutManager(this)
        rvDuaList.adapter = adapter
    }
}
