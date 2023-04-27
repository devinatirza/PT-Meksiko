public class CounterFragment extends Fragment {

    private TextView counterTextView;
    private int counter;
    private SharedPreferences sharedPreferences;

    public CounterFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        counterTextView = view.findViewById(R.id.counter_text_view);
        Button addButton = view.findViewById(R.id.add_button);
        Button subtractButton = view.findViewById(R.id.subtract_button);
        Button resetButton = view.findViewById(R.id.reset_button);

        sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);

        counter = sharedPreferences.getInt("counter", 0);
        counterTextView.setText(String.valueOf(counter));

        // Set click listeners for buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                counterTextView.setText(String.valueOf(counter));
                saveCounterToSharedPreferences();
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                counterTextView.setText(String.valueOf(counter));
                saveCounterToSharedPreferences();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                counterTextView.setText(String.valueOf(counter));
                saveCounterToSharedPreferences();
            }
        });

        return view;
    }

    private void saveCounterToSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counter", counter);
        editor.apply();
    }

}
