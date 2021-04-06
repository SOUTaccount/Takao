package first.example.takaotakao;

public class Type {
    private String name;
    private int resourceId;
    public static final Type[] types={
            new Type("Pizza",R.drawable.diavolo),
            new Type("Pasta",R.drawable.diavolo),
            new Type("Hot cook",R.drawable.diavolo)
    };
    private Type(String name,int resourceId){
        this.name=name;
        this.resourceId=resourceId;
    }
    public String getName(){
        return name;
    }
    public int getResourceId(){
        return resourceId;
    }
}
