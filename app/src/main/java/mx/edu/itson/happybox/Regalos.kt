package mx.edu.itson.happybox

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var catalogo: ArrayList<Detalles> = ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)
        var option: String? = intent.getStringExtra("selection")
        agregarProductos(option)

        var listView: GridView = findViewById(R.id.catalogo_detalles) as GridView

        var adaptador: DetalleAdapter = DetalleAdapter(this, catalogo)
        listView.adapter = adaptador
    }
    private fun agregarProductos(option: String?) {
        when(option){
            "Detalles" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas, "280"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "320"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "330"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "190"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "150"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "370"))
            }
            "Globos" ->{
                catalogo.add(Detalles(R.drawable.globoamor, "240"))
                catalogo.add(Detalles(R.drawable.globocumple, "820"))
                catalogo.add(Detalles(R.drawable.globofestejo, "260"))
                catalogo.add(Detalles(R.drawable.globonum, "760"))
                catalogo.add(Detalles(R.drawable.globos, "450"))
                catalogo.add(Detalles(R.drawable.globos, "240"))
            }
            "Peluches" ->{
                catalogo.add(Detalles(R.drawable.peluchemario, "320"))
                catalogo.add(Detalles(R.drawable.pelucheminecraft, "320"))
                catalogo.add(Detalles(R.drawable.peluchepeppa, "290"))
                catalogo.add(Detalles(R.drawable.peluches, ""))
                catalogo.add(Detalles(R.drawable.peluchesony, "330"))
                catalogo.add(Detalles(R.drawable.peluchestich, "280"))
                catalogo.add(Detalles(R.drawable.peluchevarios, "195"))
            }
            "Regalos" ->{
                catalogo.add(Detalles(R.drawable.regaloazul, "80"))
                catalogo.add(Detalles(R.drawable.regalobebe, "290"))
                catalogo.add(Detalles(R.drawable.regalocajas, "140"))
                catalogo.add(Detalles(R.drawable.regalocolores, "85"))
                catalogo.add(Detalles(R.drawable.regalos, ""))
                catalogo.add(Detalles(R.drawable.regalovarios, "75"))
            }
            "Tazas" ->{
                catalogo.add(Detalles(R.drawable.tazaabuela, "120"))
                catalogo.add(Detalles(R.drawable.tazalove, "120"))
                catalogo.add(Detalles(R.drawable.tazaquiero, "260"))
                catalogo.add(Detalles(R.drawable.tazas, "280"))
            }
        }
    }

    class DetalleAdapter: BaseAdapter {
        var context: Context? = null
        var detalles = ArrayList<Detalles>()

        constructor(context: Context, detalles: ArrayList<Detalles>){
            this.context = context
            this.detalles = detalles
        }
        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(p0: Int): Any {
            return detalles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }
        override fun getView(position: Int, coverView: View?, parent: ViewGroup?): View {
            var detalles = detalles[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)

            var image: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
            var precio: TextView = vista.findViewById(R.id.tv_regalo_precio)




            image.setImageResource(detalles.image)
            precio.setText("$${detalles.precio}")

//            image.setOnClickListener{
//                var intento = Intent(context, DetalleRegalos::class.java)
//
//                intento.putExtra("image", detalles.image)
//                intento.putExtra("precio", "$${detalles.precio}")
//                context!!.startActivity(intento)
//            }
            return vista
        }
    }
}