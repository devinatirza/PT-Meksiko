bottomNavigationView.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_counter:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CounterFragment()).commit();
                        return true;
                    case R.id.navigation_area:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AreaFragment()).commit();
                        return true;
                    case R.id.navigation_volume:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new VolumeFragment()).commit();
                        return true;
                }
                return false;

