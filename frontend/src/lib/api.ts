const API=process.env.NEXT_PUBLIC_API_URL||'http://localhost:8080/api';
export async function getJson(path:string){const r=await fetch(`${API}${path}`,{next:{revalidate:30}}); if(!r.ok) return []; return r.json();}
export async function getProjects(){return getJson('/projects');}
export async function getSkills(){return getJson('/skills');}
export async function getAbout(){const r=await fetch(`${API}/about`,{next:{revalidate:30}}); if(!r.ok) return null; return r.json();}
export async function getBlogs(){return getJson('/blogs');}
export async function getExperience(){return getJson('/experience');}
export async function getTestimonials(){return getJson('/testimonials');}
export async function getServices(){return getJson('/services');}
export async function sendMessage(data:object){const r=await fetch(`${API}/contact`,{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(data)}); if(!r.ok) throw new Error('Failed'); return r.json();}
