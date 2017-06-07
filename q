app/src/main/java/com/example/mihaipop/firebaseapp/AccountInfoActivity.java[36m:[m22[36m:[m    private TextView [1;31mphone[m;
app/src/main/java/com/example/mihaipop/firebaseapp/AccountInfoActivity.java[36m:[m34[36m:[m        [1;31mphone[m = (TextView)findViewById(R.id.infoPhone);
app/src/main/java/com/example/mihaipop/firebaseapp/AccountInfoActivity.java[36m:[m51[36m:[m        mFirebase.snapShot(firstname, lastname, country, [1;31mphone[m, privat);
app/src/main/java/com/example/mihaipop/firebaseapp/Firebase.java[36m:[m61[36m:[m    public void  snapShot(final TextView firstname, final TextView lastname, final TextView country, final TextView [1;31mphone[m, final Switch privat) {
app/src/main/java/com/example/mihaipop/firebaseapp/Firebase.java[36m:[m67[36m:[m                getAccountInfo(dataSnapshot, firstname, lastname, country,[1;31mphone[m,privat);
app/src/main/java/com/example/mihaipop/firebaseapp/Firebase.java[36m:[m139[36m:[m    public void getAccountInfo(DataSnapshot dataSnapshot,TextView firstname, TextView lastname, TextView country, TextView [1;31mphone[m, Switch privat) {
app/src/main/java/com/example/mihaipop/firebaseapp/Firebase.java[36m:[m149[36m:[m                [1;31mphone[m.setText("Telefon: " + postSnapshot.getValue(UserData.class).getPhone());
app/src/main/java/com/example/mihaipop/firebaseapp/UserData.java[36m:[m15[36m:[m    private String [1;31mphone[m;
app/src/main/java/com/example/mihaipop/firebaseapp/UserData.java[36m:[m34[36m:[m    public UserData(String firstName, String lastName, String [1;31mphone[m, String country) {
app/src/main/java/com/example/mihaipop/firebaseapp/UserData.java[36m:[m37[36m:[m        this.[1;31mphone[m = [1;31mphone[m;
app/src/main/java/com/example/mihaipop/firebaseapp/UserData.java[36m:[m55[36m:[m        return [1;31mphone[m;
app/src/main/java/com/example/mihaipop/firebaseapp/UserData.java[36m:[m99[36m:[m    public void setPhone(String [1;31mphone[m) {
app/src/main/java/com/example/mihaipop/firebaseapp/UserData.java[36m:[m100[36m:[m        this.[1;31mphone[m = [1;31mphone[m;
app/src/main/java/com/example/mihaipop/firebaseapp/UserDetails.java[36m:[m24[36m:[m    private TextView [1;31mphone[m;
app/src/main/java/com/example/mihaipop/firebaseapp/UserDetails.java[36m:[m43[36m:[m        [1;31mphone[m = (TextView) findViewById(R.id.[1;31mphone[mD);
app/src/main/java/com/example/mihaipop/firebaseapp/UserDetails.java[36m:[m75[36m:[m        String [1;31mphone[m = this.[1;31mphone[m.getText().toString().trim();
app/src/main/java/com/example/mihaipop/firebaseapp/UserDetails.java[36m:[m92[36m:[m        // validate [1;31mphone[m
app/src/main/java/com/example/mihaipop/firebaseapp/UserDetails.java[36m:[m93[36m:[m        if ([1;31mphone[m.length() == 0 || ![1;31mphone[m.matches("[0-9][0-9]{9,}")) {
app/src/main/java/com/example/mihaipop/firebaseapp/UserDetails.java[36m:[m104[36m:[m        UserData userInformation = new UserData(firstName, lastName, [1;31mphone[m, country);
app/src/main/java/com/example/mihaipop/firebaseapp/Validation.java[36m:[m41[36m:[m    public static boolean validPhone(String [1;31mphone[m) {
app/src/main/java/com/example/mihaipop/firebaseapp/Validation.java[36m:[m44[36m:[m        for(int i = 0; i < [1;31mphone[m.length(); i++) {
app/src/main/java/com/example/mihaipop/firebaseapp/Validation.java[36m:[m45[36m:[m            if(([1;31mphone[m.charAt(i) <= '0') && ([1;31mphone[m.charAt(i) >= '9')) {
app/src/main/java/com/example/mihaipop/firebaseapp/Validation.java[36m:[m73[36m:[m    public static boolean validData(String firstName, String lastName, String [1;31mphone[m, String country){
app/src/main/java/com/example/mihaipop/firebaseapp/Validation.java[36m:[m77[36m:[m        if((!validString(firstName)) || (!validString(lastName)) || (!validString([1;31mphone[m)) || (!validString(country))) {
app/src/main/java/com/example/mihaipop/firebaseapp/Validation.java[36m:[m84[36m:[m        if(!validPhone([1;31mphone[m)){
app/src/main/res/layout/activity_user_details.xml[36m:[m23[36m:[m        android:id="@+id/[1;31mphone[mD"
app/src/main/res/layout/activity_user_details.xml[36m:[m27[36m:[m        android:inputType="[1;31mphone[m"
