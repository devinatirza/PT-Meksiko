public class VolumeCalculatorFragment extends Fragment {
    private EditText etPanjang, etLebar, etTinggi, etJariJari, etTinggiTabung;
    private Button btnHitung;
    private TextView tvHasil;

    public VolumeCalculatorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volume_calculator, container, false);

        etPanjang = view.findViewById(R.id.et_panjang);
        etLebar = view.findViewById(R.id.et_lebar);
        etTinggi = view.findViewById(R.id.et_tinggi);
        etJariJari = view.findViewById(R.id.et_jari_jari);
        etTinggiTabung = view.findViewById(R.id.et_tinggi_tabung);
        btnHitung = view.findViewById(R.id.btn_hitung);
        tvHasil = view.findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double panjang = Double.parseDouble(etPanjang.getText().toString());
                double lebar = Double.parseDouble(etLebar.getText().toString());
                double tinggi = Double.parseDouble(etTinggi.getText().toString());
                double jariJari = Double.parseDouble(etJariJari.getText().toString());
                double tinggiTabung = Double.parseDouble(etTinggiTabung.getText().toString());

                double volume = 0;
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.rb_balok) {
                    volume = panjang * lebar * tinggi;
                } else if (selectedId == R.id.rb_piramid) {
                    volume = (panjang * lebar * tinggi) / 3;
                } else if (selectedId == R.id.rb_lingkaran) {
                    volume = Math.PI * jariJari * jariJari * tinggiTabung;
                }

                tvHasil.setText("Volume: " + volume);
            }
        });

        return view;
    }
}
