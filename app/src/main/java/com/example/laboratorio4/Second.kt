package com.example.laboratorio4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.laboratorio4.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Second.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Second.newInstance] factory method to
 * create an instance of this fragment.
 */
class Second : Fragment() {



    private lateinit var place:String
    private lateinit var comment:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSecondBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_second, container, false
        )
        binding.goBack="Comment"
        binding.hintText="Show this comment"

        binding.backButton.setOnClickListener{
            comment = binding.sendBack.text.toString()
            val bundle = bundleOf("comment_shown" to comment)

            view!!.findNavController().navigate(R.id.action_second_to_commentFragment, bundle)
        }

        arguments?.let {
            place = it.getString("info_shown").toString()
        }


        if(place.equals("Tikal")){
            binding.placeKnown="Tikal"
            binding.showPlace.setImageResource(R.drawable.tikal)
            binding.placeDesc="Tikal Tikal es el sitio excavado más grande de las Américas y contiene algunos de los restos arqueológicos más fascinantes de la antigua civilización Maya. Es la reserva natural y cultural más célebre de Guatemala y fue declarado parque nacional en 1955 y sitio de Patrimonio Mundial por la Unesco en 1979. \n \nTikal comprende 576 km2 de selva exuberante rodeando el centro ceremonial. Tomó a la Universidad de Pensilvania 13 años develar alrededor de 16 km2 cuadrados de estructuras en Tikal. No obstante, muchas quedan aún por descubrirse. Entonces, tome un consejo... ¡No trate de conocer todo Tikal en un día, aunque usted esté en excelente forma!\n\nTikal posee una cierta magia... Como todos los acertijos sin respuestas fascina a cualquiera y nosotros nos atrevemos a decir... Tikal es tan irresistible que una vez usted esté allí, ¡se encontrará a sí mismo queriendo quedarse un momento más!\n \nhttp://www.parque-tikal.com/#!/tikal_home"
        }else if(place.equals("Atitlan")){
            binding.placeKnown="Atitlan"
            binding.showPlace.setImageResource(R.drawable.atitlan)
            binding.placeDesc="Uno de los atractivos turísticos más visitados en Guatemala. A orillas del lago se sitúan los volcanes de Atitlán, Tolimán y San Pedro La Laguna (“Los Tres Gigantes”), formando así un paisaje impresionante.\n \nSituado en el departamento de Sololá, el Lago de Atitlán es uno de los atractivos turísticos más visitados en Guatemala, y fue nominado como una de las siete maravillas del mundo. Es considerado como el lago más bello del mundo, y también se concibe como uno de los sitios más singulares. El lago tiene una extensión de 130 Km2, y el color de sus aguas varía del azul profundo al verde. El lago, formado hace aproximadamente 84,000 años producto de una erupción volcánica, se encuentra a 1,500 metros sobre el nivel del mar, con una longitud de 18 kilómetros y una profundidad hasta de 341 metros, convirtiéndolo así en el lago más profundo de Centroamérica.\n \nLos cerros y volcanes alrededor del lago ofrecen bosques densos y tupidos, donde el senderismo se puede practicar sin problemas, pudiéndose observar una gran variedad de aves, desde los poco tímidos pájaros carpinteros, hasta el Quetzal, ave nacional.\n \nA orillas del lago se sitúan los volcanes de Atitlán, Tolimán y San Pedro La Laguna (“Los Tres Gigantes”), formando así un paisaje impresionante. Alrededor del lago pueden visitarse los municipios de Santiago Atitlán, San Lucas Tolimán, San Antonio Palopó, Santa Catarina Palopó, Panajachel y San Pedro La Laguna. Muchos de los habitantes de estos pueblos son descendientes de los grupos cakchiqueles y tzutuhiles. Los pueblos ofrecen diferentes ambientes a los turistas, desde la paz característica de Santa Cruz La Laguna y San Pedro La Laguna, lugares muy visitados, hasta la atmósfera festiva de Panajachel, el punto más popular de Sololá. También podemos encontrar todo tipo de artesanías como tejidos, vasijas, cadenas, pulseras, tambores y hamacas, entre otras. Se puede llegar a San Pedro La Laguna, Santa Clara La Laguna y el resto de pueblos por tierra, sin embargo, por la cantidad de opciones de hospedaje en Panajachel, suele ser más conveniente llegar hasta allá, y desde ahí partir en lancha a los pueblos alrededor. El recorrido desde la ciudad de Guatemala hasta el Lago de Atitlán lleva más o menos dos horas con cuarenta minutos.\n \nhttps://www.visitcentroamerica.com/visitar/lago-atitlan-pueblos/"
        }else if(place.equals("Izabal")){
            binding.placeKnown="Izabal"
            binding.showPlace.setImageResource(R.drawable.izabal)
            binding.placeDesc="Respecto a la etimología de Izabal, se cree que se refiere al Golfo Dulce, sin embargo, ahora puede decirse que proviene del vasco o vascuence, en cuyo idioma: Zabal equivale a ancho, posiblemente por la bahía. Es preciso recordar que los miembros del Real Consulado de Comercio en su mayoría eran vascos, o sus descendientes. Según Fuentes y Guzmán, indicó que al Golfo Dulce le vino el nombre por lo dulce de sus aguas.\n" +
                    "\n" +
                    "Por el año de 1803, según documentos que obran en el Archivo General de Centroamérica, apareció el primer reglamento para embarques y desembarques del Real Consulado, en que se menciona a Izabal.\n" +
                    "\n" +
                    "Durante el período hispánico este departamento pertenecía al Corregimiento de Chiquimula de la Sierra, luego fue distrito para ser creado como departamento el 18 de mayo de 1866. Desde el 11 de marzo de 1951, el departamento de Izabal pertenecía al Obispado de Zacapa, integrado por Zacapa, Chiquimula e Izabal.\n \n http://www.eguate.com/site/es/historia/departamental/izabal.html"
        }


        return binding.root
    }


}
