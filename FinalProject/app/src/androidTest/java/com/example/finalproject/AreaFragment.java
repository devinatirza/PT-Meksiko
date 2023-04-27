public class AreaCalculatorFragment extends Fragment {
    private EditText etWidth, etHeight, etRadius;
    private Button btnCalculate;
    private TextView tvResult;

    public AreaCalculatorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_calculator, container, false);

        etWidth = view.findViewById(R.id.et_width);
        etHeight = view.findViewById(R.id.et_height);
        etRadius = view.findViewById(R.id.et_radius);
        btnCalculate = view.findViewById(R.id.btn_calculate);
        tvResult = view.findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String widthText = etWidth.getText().toString();
                String heightText = etHeight.getText().toString();
                String radiusText = etRadius.getText().toString();

                double width = 0.0;
                double height = 0.0;
                double radius = 0.0;

                try {
                    width = Double.parseDouble(widthText);
                } catch (NumberFormatException e) {

                }

                try {
                    height = Double.parseDouble(heightText);
                } catch (NumberFormatException e) {

                }

                try {
                    radius = Double.parseDouble(radiusText);
                } catch (NumberFormatException e) {

                }

                double squareArea = width * height;
                double triangleArea = 0.5 * width * height;
                double circleArea = Math.PI * radius * radius;

                // Display the result
                String result = "Square area: " + squareArea + "\n"
                        + "Triangle area: " + triangleArea + "\n"
                        + "Circle area: " + circleArea;
                tvResult.setText(result);
            }
        });

        return view;
    }
}
